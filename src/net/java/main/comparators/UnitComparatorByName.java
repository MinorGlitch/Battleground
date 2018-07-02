package net.java.main.comparators;

import net.java.main.interfaces.Unit;

import java.util.Comparator;

public class UnitComparatorByName implements Comparator<Unit> {
    @Override
    public int compare(Unit unitImpl1, Unit unitImpl2) {
        return unitImpl1.getName().compareTo(unitImpl2.getName());
    }
}
