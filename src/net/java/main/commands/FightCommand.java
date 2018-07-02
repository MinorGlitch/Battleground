package net.java.main.commands;

import net.java.main.constants.FightConstants;
import net.java.main.exceptions.GameException;
import net.java.main.exceptions.NotEnoughEnergyException;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Spell;
import net.java.main.interfaces.Unit;
import net.java.main.models.position.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FightCommand extends Command {
    public FightCommand(Battleground battleground, Repository repository) {
        super(battleground, repository);
    }

    @Override
    public String execute(String[] args) throws NotEnoughEnergyException {
        List<Unit> deadUnits = new ArrayList<>();

        Collection<Unit> allUnits = this.getRepository().findAll();

        if (allUnits.size() < 2) {
            return FightConstants.NOT_ENOUGH_PLAYERS_MESSAGE;
        }

        StringBuilder result = new StringBuilder();
        for (Unit unit : allUnits) {
            if (unit.getHealthPoints() <= 0) {
                continue;
            }

            Position currentUnitPosition = unit.getPosition();
            int range = unit.getRange();

            List<Unit> targets = this.getBattleground().getUnitsInRange(currentUnitPosition, range);

            if (targets.isEmpty()) {
                continue;
            }

            Unit target = unit.getCombatHandler().pickNextTarget(targets);
            Spell spell = unit.getCombatHandler().generateAttack();

            boolean canPenetrateDefence = spell.getDamage() > target.getDefencePoints();

            //TODO: FIX DAMAGE TO UNITS
            if (canPenetrateDefence) {
                target.setHealthPoints(target.getHealthPoints() - spell.getDamage());

                result.append(String.format(FightConstants.SPELL_CASTED_MESSAGE,
                                        unit.getName(),
                                        spell.getClass().getSimpleName(),
                                        spell.getDamage()));

                if (target.getHealthPoints() <= 0) {
                    target.setHealthPoints(0);

                    result.append(String.format(FightConstants.PLAYER_KILLED_MESSAGE,
                            unit.getName(), target.getName()))
                            .append(System.lineSeparator());

                    deadUnits.add(unit);
                }
            }
        }

        String resultString = result.toString().trim();

        if (resultString.isEmpty()) {
            return FightConstants.NO_PLAYERS_IN_RANGE_MESSAGE;
        }

        removeDeadPlayers(deadUnits);

        return resultString;
    }

    private void removeDeadPlayers(List<Unit> deadUnits) {
        for (Unit unit : deadUnits) {
            this.getRepository().remove(unit);
            this.getBattleground().remove(unit);
        }
    }
}
