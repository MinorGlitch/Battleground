package net.java.main;

import net.java.main.core.Engine;
import net.java.main.dispachers.CommandDispatcher;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;
import net.java.main.io.OutputWriter;
import net.java.main.models.battleground.BattlegroundImpl;
import net.java.main.repositories.UnitRepository;

public class Main {

    public static void main(String[] args) {
        OutputWriter writer = new OutputWriter();

        Battleground battleground = new BattlegroundImpl();
        Repository<Unit> repository = new UnitRepository();
        CommandDispatcher commandDispatcher = new CommandDispatcher(battleground, repository);

        Engine gameEngine = new Engine(writer, commandDispatcher);
        gameEngine.start();
    }
}
