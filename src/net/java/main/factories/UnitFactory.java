package net.java.main.factories;

import net.java.main.enums.UnitType;
import net.java.main.interfaces.Unit;
import net.java.main.models.position.Position;
import net.java.main.models.units.Carrier;
import net.java.main.models.units.Marine;

public final class UnitFactory {
    public static Unit createUnit(UnitType type, String name, Position position) {
        switch (type) {
            case MARINE:
                return new Marine(name, position, CombatHandlerFactory.createCombatHandler(UnitType.MARINE));
            case CARRIER:
                return new Carrier(name, position, CombatHandlerFactory.createCombatHandler(UnitType.CARRIER));
            default:
                    return null;
        }
    }
}
