package net.java.main.factories;

import net.java.main.enums.UnitType;
import net.java.main.exceptions.GameException;
import net.java.main.handlers.CarrierCombatHandler;
import net.java.main.handlers.MarineCombatHandler;
import net.java.main.interfaces.CombatHandler;

public final class CombatHandlerFactory {

    public static CombatHandler createCombatHandler(UnitType unitType) {
        switch (unitType) {
            case MARINE:
                return new MarineCombatHandler();
            case CARRIER:
                return new CarrierCombatHandler();
            default:
                throw null;
        }
    }
}
