package net.java.main.handlers;

import net.java.main.constants.ExceptionConstants;
import net.java.main.enums.SpellType;
import net.java.main.exceptions.NotEnoughEnergyException;
import net.java.main.factories.SpellFactory;
import net.java.main.interfaces.Spell;
import net.java.main.interfaces.Unit;

public class MarineCombatHandler extends CombatHandlerImpl {
    private static int HALF_MARINE_HEALTH = 25;

    public MarineCombatHandler() {
        super();
    }

    private int getAttackDamage() {
        Unit unit = super.getUnit();
        int energyCost = unit.getAttackPoints();

        if (unit.getHealthPoints() <= HALF_MARINE_HEALTH) {
            return energyCost * 2;
        }

        return energyCost;
    }

    @Override
    public Spell generateAttack() throws NotEnoughEnergyException {
        Spell spell = SpellFactory.createSpell(SpellType.RAGESHOOT, this.getAttackDamage());
        Unit unit = super.getUnit();

        if (unit.getEnergyPoints() <= spell.getEnergyCost()) {
            throw new NotEnoughEnergyException(ExceptionConstants.NOT_ENOUGH_ENERGY_EXCEPTION_MESSAGE);
        }

        unit.setEnergyPoints(unit.getEnergyPoints() - spell.getEnergyCost());

        return spell;
    }
}
