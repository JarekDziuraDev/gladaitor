package com.codecool.gladiator.model.gladiators;

public abstract class Gladiator {

    private final String name;
    private final int baseHp;
    private final int baseSp;
    private final int baseDex;
    private int level;

    private int HP;
    private int SP;
    private int DEX;

    /**
     * Constructor for Gladiators
     *
     * @param name the gladiator's name
     * @param baseHp the gladiator's base Health Points
     * @param baseSp the gladiator's base Strength Points
     * @param baseDex the gladiator's base Dexterity Points
     * @param level the gladiator's starting Level
     */
    public Gladiator(String name, int baseHp, int baseSp, int baseDex, int level) {
        this.name = name;
        this.baseHp = baseHp;
        this.baseSp = baseSp;
        this.baseDex = baseDex;
        this.level = level;

        this.HP = getMaxHp();
        this.SP = getMaxSp();
        this.DEX = getMaxDex();
    }

    /**
     * @return HP multiplier of the gladiator subclass
     */
    protected abstract Multiplier getHpMultiplier();

    /**
     * @return SP multiplier of the gladiator subclass
     */
    protected abstract Multiplier getSpMultiplier();

    /**
     * @return DEX multiplier of the gladiator subclass
     */
    protected abstract Multiplier getDexMultiplier();

    /**
     * @return Gladiator's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the full name of the gladiator
     * assembled by the subtype and the name
     * (e.g. "Brutal Brutus" or "Archer Leo")
     *
     * @return the full name
     */
    public String getFullName() {
        return this.getClass().getName() + " " + name;
    }


    public enum Multiplier {
        Low(0.75),
        Medium(1.0),
        High(1.25);

        private final double value;

        Multiplier(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    public void levelUp() {
        this.level++;
        this.HP = getMaxHp();
        this.SP = getMaxSp();
        this.DEX = getMaxDex();
    }

    public int getMaxHp() {
        double result = this.baseHp * getHpMultiplier().value * this.level;
        return (int)result;
    }

    public int getMaxSp() {
        double result = this.baseSp * getHpMultiplier().value * this.level;
        return (int)result;
    }

    public int getMaxDex() {
        double result = this.baseDex * getHpMultiplier().value * this.level;
        return (int)result;
    }

    public void decreaseHpBy(int value) {
       this.HP = this.HP - value;
    }

    public void healUp(int value) {
        this.HP = this.HP - value;
    }

    public boolean isDead() {
        return this.getMaxHp() <= 0;
    }

}
