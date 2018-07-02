package net.java.main.commands;

import net.java.main.constants.ExceptionConstants;
import net.java.main.enums.UnitType;
import net.java.main.exceptions.GameException;
import net.java.main.exceptions.InvalidPositionException;
import net.java.main.exceptions.UnknownUnitTypeException;
import net.java.main.factories.UnitFactory;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;
import net.java.main.models.position.Position;

public class SpawnCommand extends Command {

    public SpawnCommand(Battleground battleground, Repository repository){
        super(battleground, repository);
    }

    @Override
    public String execute(String[] args) throws GameException {
        UnitType type;

        try {
            type = UnitType.valueOf(args[1].toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new UnknownUnitTypeException(ExceptionConstants.INVALID_UNIT_TYPE_EXCEPTION_MESSAGE);
        }

        String name = args[2];
        Position position = new Position(Integer.valueOf(args[3]), Integer.valueOf(args[4]));


        Unit unit = UnitFactory.createUnit(type, name, position);

        super.getRepository().save(unit);
        try {
            super.getBattleground().add(unit);
        } catch (InvalidPositionException ex) {
            throw new InvalidPositionException(ExceptionConstants.INVALID_COORDINATES_EXCEPTION_MESSAGE);
        }

        return String.format("%s of type %s has spawn @(%d, %d)", unit.getName(), unit.getClass().getSimpleName(),
                position.getX(), position.getY());
    }

}
