package net.java.main.dispachers;

import net.java.main.commands.*;
import net.java.main.enums.CommandType;
import net.java.main.exceptions.GameException;
import net.java.main.exceptions.InvalidPositionException;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandDispatcher implements net.java.main.interfaces.CommandDispatcher {
    private static final String UNKNOWN_COMMAND_EXCEPTION_MESSAGE = "Unknown command!";

    private Map<String, Command> commands;

    public CommandDispatcher(Battleground battleground, Repository<Unit> repository) {
        this.commands = new LinkedHashMap<>();
        this.seedCommands(battleground, repository);
    }

    public String dispatchCommand(String[] args) throws GameException {
        CommandType val;

        try {
            val = CommandType.valueOf(args[0].toUpperCase().replaceAll("-", "_"));
        } catch (IllegalArgumentException ex) {
            val = CommandType.UNKNOWN;
        }

        switch (val) {
            case GAME_OVER:
                return commands.get(val.toString()).execute(args);
            case SPAWN:
                try {
                    return commands.get(val.toString()).execute(args);
                } catch (InvalidPositionException ex) {
                    return ex.getMessage();
                }
            case FIGHT:
                return commands.get(val.toString()).execute(args);
            case STATUS:
                return commands.get(val.toString()).execute(args);
            case MOVE:
                return commands.get(val.toString()).execute(args);
            case UNKNOWN:
                throw new GameException(UNKNOWN_COMMAND_EXCEPTION_MESSAGE);
                default:
                    return null;
        }
    }

    private void seedCommands(Battleground battleground, Repository<Unit> repository) {
        commands.put(CommandType.MOVE.toString(), new MoveCommand(battleground, repository));
        commands.put(CommandType.FIGHT.toString(), new FightCommand(battleground, repository));
        commands.put(CommandType.SPAWN.toString(), new SpawnCommand(battleground, repository));
        commands.put(CommandType.STATUS.toString(), new StatusCommand(battleground, repository));
        commands.put(CommandType.GAME_OVER.toString(), new GameOverCommand(battleground, repository));

    }
}

