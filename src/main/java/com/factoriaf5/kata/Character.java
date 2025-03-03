package com.factoriaf5.kata;

public class Character {
    private static final int MAX_HEALTH = 1000;
    private int health;
    private int level;
    private boolean isAlive;

    public Character() {
        this(MAX_HEALTH, 1, true);
    }

    public Character(int health, int level, boolean isAlive) {
        setHealth(health);
        setLevel(level);
        this.isAlive = isAlive;
    }

    public void dealDamage(Character target, int damage) {
        if (this == target) return;
        if (!target.isAlive()) return;


        if (this.level >= target.getLevel() + 5) {
            damage *= 1.5;
        } else if (this.level <= target.getLevel() - 5) {
            damage *= 0.5;
        }

        target.setHealth(target.getHealth() - damage);
    }

    public void heal(int healAmount) {
        if (this.isAlive()) {
            this.setHealth(this.getHealth() + healAmount);
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, MAX_HEALTH));
        this.isAlive = this.health > 0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = Math.max(level, 1);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
        if (!alive) this.health = 0;
    }
}
