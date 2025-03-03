package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    @Test
    public void characterShouldHaveInitialValues() {
        Character character = new Character();
        assertEquals(1000, character.getHealth());
        assertEquals(1, character.getLevel());
        assertTrue(character.isAlive());
    }

    @Test
    void characterCannotDamageItself() {
        Character character = new Character();
        character.dealDamage(character, 100);
        assertEquals(1000, character.getHealth());
    }

    @Test
    void characterShouldDealDamage() {
        Character attacker = new Character(1000, 1, true);
        Character target = new Character(1000, 1, true);

        attacker.dealDamage(target, 100);
        assertEquals(900, target.getHealth());
    }

    @Test
    void characterShouldDieWhenHealthReachesZero() {
        Character attacker = new Character(1000, 1, true);
        Character target = new Character(1000, 1, true);

        attacker.dealDamage(target, 1000);
        assertFalse(target.isAlive());
    }

    @Test
    void deadCharacterCannotBeHealed() {
        Character target = new Character(0, 1, false);
        target.heal(100);
        assertEquals(0, target.getHealth());
    }

    @Test
    void healingCannotExceedMaxHealth() {
        Character character = new Character();
        character.setHealth(900);
        character.heal(200);
        assertEquals(1000, character.getHealth());
    }

    @Test
    void characterCanOnlyHealItself() {
        Character character1 = new Character();
        Character character2 = new Character();

        character1.heal(100);
        assertEquals(1000, character1.getHealth());

        character2.heal(100);
        assertEquals(1000, character2.getHealth());
    }
}
