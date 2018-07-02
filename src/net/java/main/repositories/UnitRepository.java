package net.java.main.repositories;

import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

import java.util.*;

public class UnitRepository implements Repository<Unit> {
    public Map<String, Unit> units;

    public UnitRepository() {
        this.units = new LinkedHashMap<>();
    }

    @Override
    public void save(Unit element) {
        units.put(element.getName(), element);
    }

    @Override
    public void remove(Unit element) {
        units.remove(element.getName());
    }

    @Override
    public Collection<Unit> findAll() {
        return units.values();
    }

    @Override
    public Unit findByName(String name) {
        return units.get(name);
    }
}
