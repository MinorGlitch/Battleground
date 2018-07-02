package net.java.main.commands;

import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Repository;

public class GameOverCommand extends Command {

    public GameOverCommand(Battleground battleground, Repository repository) {
        super(battleground, repository);
    }

    @Override
    public String execute(String[] args) {
        return "Game over!";
    }
}
