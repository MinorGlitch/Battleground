package net.java.main.commands;

import net.java.main.constants.ExceptionConstants;
import net.java.main.exceptions.GameException;
import net.java.main.exceptions.InvalidPositionException;
import net.java.main.exceptions.InvalidUnitException;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;
import net.java.main.models.position.Position;

public class MoveCommand extends Command {
    public MoveCommand(Battleground battleground, Repository repository) {
        super(battleground, repository);
    }

    @Override
    public String execute(String[] args) throws GameException {
        Unit unit = super.getRepository().findByName(args[1]);

        if (unit == null) {
            throw new InvalidUnitException(ExceptionConstants.NOT_EXISTING_UNIT_EXCEPTION_MESSAGE);
        }

        Position position = new Position(Integer.valueOf(args[2]),Integer.valueOf(args[3]));

        try {
            super.getBattleground().move(unit, position);
        } catch (InvalidPositionException ex) {
            throw new InvalidUnitException(ExceptionConstants.POSITION_NOT_EMPTY_EXCEPTION_MESSAGE);
        }

        unit.setPosition(position);

        return String.format("%s moved to (%d, %d)", unit.getName(),
                unit.getPosition().getX(), unit.getPosition().getY());
    }
}
