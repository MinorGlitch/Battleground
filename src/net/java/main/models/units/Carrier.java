package net.java.main.models.units;

import net.java.main.constants.UnitConstants;
import net.java.main.interfaces.CombatHandler;
import net.java.main.models.position.Position;

public class Carrier extends UnitImpl {
    private static final int RANGE = 2;

    public Carrier(String name, Position position, CombatHandler combatHandler) {
        super(name, RANGE, position,
                UnitConstants.HEALTH_POINTS, UnitConstants.ENERGY_POINTS,
                UnitConstants.ATTACK_POINTS, UnitConstants.DEFENCE_POINTS, combatHandler);
    }
}
