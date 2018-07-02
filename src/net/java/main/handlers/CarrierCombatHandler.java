package net.java.main.handlers;

import net.java.main.constants.ExceptionConstants;
import net.java.main.enums.SpellType;
import net.java.main.exceptions.NotEnoughEnergyException;
import net.java.main.factories.SpellFactory;
import net.java.main.interfaces.Unit;
import net.java.main.interfaces.Spell;

public class CarrierCombatHandler extends CombatHandlerImpl {
    private int spellCount;

    public CarrierCombatHandler() {
        super();
    }

    @Override
    public Spell generateAttack() throws NotEnoughEnergyException {
        Unit unit = super.getUnit();

        Spell spell = SpellFactory.createSpell(SpellType.BULLETRAIN, unit.getAttackPoints());

        spellCount++;

        if (this.spellCount % 3 == 0) {
            return spell;
        } else {
            if (unit.getEnergyPoints() <= spell.getEnergyCost()) {
                throw new NotEnoughEnergyException(ExceptionConstants.NOT_ENOUGH_ENERGY_EXCEPTION_MESSAGE);
            }
        }

        unit.setEnergyPoints(unit.getEnergyPoints() - spell.getEnergyCost());

        return spell;
    }
}
