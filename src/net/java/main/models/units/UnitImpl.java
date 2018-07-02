package net.java.main.models.units;

import net.java.main.interfaces.CombatHandler;
import net.java.main.interfaces.Unit;
import net.java.main.models.position.Position;

public class UnitImpl implements Unit {
    private String name;
    private Integer range;
    private Position position;
    private int healthPoints;
    private int energyPoints;
    private int attackPoints;
    private int defencePoints;
    private CombatHandler combatHandler;

    protected UnitImpl(
            String name,
            int range,
            Position position,
            int healthPoints,
            int energyPoints,
            int attackPoints,
            int defencePoints,
            CombatHandler combatHandler) {
        this.name = name;
        this.range = range;
        this.healthPoints = healthPoints;
        this.energyPoints = energyPoints;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.combatHandler = combatHandler;
        this.position = position;
        this.combatHandler.setUnit(this);
    }

    
    public String getName() {
        return this.name;
    }

    public int getRange() {
        return this.range;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getEnergyPoints() {
        return this.energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        this.energyPoints = energyPoints;
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }

    public int getDefencePoints() {
        return this.defencePoints;
    }

    public CombatHandler getCombatHandler() {
        return this.combatHandler;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("> ").append(this.getName()).append("\n")
                .append("-Type: ").append(this.getClass().getSimpleName()).append("\n")
                .append("-Position: " + "(").append(this.getPosition().getX())
                .append(", ").append(this.getPosition().getY()).append(")").append("\n")
                .append("-Attack Points: ").append(this.getAttackPoints()).append("\n")
                .append("-Defence Points: ").append(this.getDefencePoints()).append("\n")
                .append("-Energy Points: ").append(this.getEnergyPoints()).append("\n")
                .append("-Health Points: ").append(this.getHealthPoints());

        return sb.toString();
    }
}
