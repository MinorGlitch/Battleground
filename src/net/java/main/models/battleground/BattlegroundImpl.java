package net.java.main.models.battleground;

import net.java.main.exceptions.InvalidPositionException;
import net.java.main.interfaces.Unit;
import net.java.main.models.position.Position;
import net.java.main.models.units.UnitImpl;

import java.util.ArrayList;
import java.util.List;

public class BattlegroundImpl implements net.java.main.interfaces.Battleground {
    private Unit[][] battleground;

    public BattlegroundImpl() {
        battleground = new UnitImpl[5][5];
    }

    @Override
    public List<Unit> getUnitsInRange(Position position, int range) {
        List<Unit> units = new ArrayList<>();

        int minRow = position.getX() - range < 0 ? 0 : position.getX() - range;
        int maxRow = position.getX() + range > this.getSize() ? this.getSize() : position.getX() + range;

        int minCol = position.getY() - range < 0 ? 0 : position.getY() - range;
        int maxCol = position.getY() + range > this.getSize() ? this.getSize() : position.getY() + range;

        for (int i = minRow; i < maxRow; i++) {
            for (int j = minCol; j < maxCol; j++) {
                if (i != position.getX() || j != position.getY()) {
                    continue;
                }

                if (battleground[i][j] != null) {
                    units.add(battleground[i][j]);
                }
            }
        }

        return units;
    }

    @Override
    public void add(Unit unit) throws InvalidPositionException {
        Position unitPos = unit.getPosition();

        checkBoundaries(unitPos);

        if (battleground[unitPos.getX()][unitPos.getY()] != null) {
            throw new InvalidPositionException("");
        }

        battleground[unitPos.getX()][unitPos.getY()] = unit;
    }

    private void checkBoundaries(Position unitPos) throws InvalidPositionException {
        try {
            Object obj = battleground[unitPos.getX()][unitPos.getY()];
        } catch (IndexOutOfBoundsException ex) {
            throw new InvalidPositionException("");
        }
    }

    @Override
    public void remove(Unit unit) {
        Position unitPos = unit.getPosition();

        battleground[unitPos.getX()][unitPos.getY()] = null;
    }

    @Override
    public void move(Unit unit, Position position) throws InvalidPositionException {
        checkBoundaries(position);

        if (battleground[position.getX()][position.getY()] != null) {
            throw new InvalidPositionException("");
        }

        battleground[position.getX()][position.getY()] = unit;
    }

    @Override
    public int getSize() {
        return this.battleground.length;
    }
}
