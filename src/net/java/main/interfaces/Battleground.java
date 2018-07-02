package net.java.main.interfaces;

import net.java.main.exceptions.InvalidPositionException;
import net.java.main.models.position.Position;

import java.util.List;

public interface Battleground {

    List<Unit> getUnitsInRange(Position position, int range);

    void add(Unit unit) throws InvalidPositionException;

    void remove(Unit unit);

    void move(Unit unit, Position position) throws InvalidPositionException;

    int getSize();
}
