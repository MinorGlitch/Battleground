package net.java.main.factories;

import net.java.main.enums.SpellType;
import net.java.main.interfaces.Spell;
import net.java.main.models.spells.BulletRain;
import net.java.main.models.spells.RageShoot;

public final class SpellFactory {
    public static Spell createSpell(SpellType spellType, int damage) {
        switch (spellType) {
            case RAGESHOOT:
                return new RageShoot(damage);
            case BULLETRAIN:
                return new BulletRain(damage);
            default:
                return null;
        }
    }
}
