package net.java.main.interfaces;

import net.java.main.exceptions.NotEnoughEnergyException;

import java.util.List;

public interface CombatHandler {

    void setUnit(Unit unitImpl);

    Unit pickNextTarget(List<Unit> targetCandidates);

    net.java.main.interfaces.Spell generateAttack() throws NotEnoughEnergyException;
}
