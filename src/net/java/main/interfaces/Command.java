package net.java.main.interfaces;

import net.java.main.exceptions.GameException;

public interface Command {
    String execute(String[] args) throws GameException;
}
