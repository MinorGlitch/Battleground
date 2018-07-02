package net.java.main.handlers;

import net.java.main.comparators.UnitComparatorByHealthPoints;
import net.java.main.comparators.UnitComparatorByName;
import net.java.main.interfaces.CombatHandler;
import net.java.main.interfaces.Unit;
import net.java.main.models.units.UnitImpl;

import java.util.Comparator;
import java.util.List;

public abstract class CombatHandlerImpl implements CombatHandler{
    private Unit unit;

    protected CombatHandlerImpl() {
    }

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    protected Unit getUnit() {
        return this.unit;
    }

    @Override
    public Unit pickNextTarget(List<Unit> targetCandidates) {
        targetCandidates.sort(new UnitComparatorByHealthPoints().thenComparing(new UnitComparatorByName()));
        return targetCandidates.get(0);
    }
}
