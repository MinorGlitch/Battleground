package net.java.main.interfaces;

import net.java.main.exceptions.GameException;

public interface CommandDispatcher {
    String dispatchCommand(String[] args) throws GameException;
}
