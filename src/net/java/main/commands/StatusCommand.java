package net.java.main.commands;

import net.java.main.constants.ExceptionConstants;
import net.java.main.exceptions.GameException;
import net.java.main.exceptions.InvalidUnitException;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

public class StatusCommand extends Command {
    public StatusCommand(Battleground battleground, Repository repository) {
        super(battleground, repository);
    }

    @Override
    public String execute(String[] args) throws GameException {
        String name = args[1];

        Unit unit = super.getRepository().findByName(name);

        if (unit == null) {
            throw new InvalidUnitException(String.format(ExceptionConstants.NOT_EXISTING_UNIT_EXCEPTION_MESSAGE, name));
        }

        return unit.toString();
    }
}
