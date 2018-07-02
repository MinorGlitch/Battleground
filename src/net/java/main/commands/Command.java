package net.java.main.commands;

import net.java.main.exceptions.GameException;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

import java.util.Collection;

public abstract class Command implements net.java.main.interfaces.Command {
    private Battleground battleground;
    private Repository<Unit> repository;

    protected Command(Battleground battleground, Repository<Unit> repository) {
        this.battleground = battleground;
        this.repository = repository;
    }

    public String execute(String[] args) throws GameException {
        Collection<Unit> units = repository.findAll();

        for (Unit unit : units) {
           //TODO;
        }

        return null;
    }

    protected Battleground getBattleground() {
        return this.battleground;
    }

    protected Repository<Unit> getRepository() {
        return this.repository;
    }
}
