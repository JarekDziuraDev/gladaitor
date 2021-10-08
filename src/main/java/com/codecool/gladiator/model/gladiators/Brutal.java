package com.codecool.gladiator.model.gladiators;

public class Brutal extends Gladiator {
    public Brutal(String name, int baseHp, int baseSp, int baseDex, int level) {
        super(name, baseHp, baseSp, baseDex, level);
    }

    @Override
    protected Multiplier getHpMultiplier() {

        return Multiplier.High;
    }

    @Override
    protected Multiplier getSpMultiplier() {
        // Todo
        return Multiplier.High;
    }

    @Override
    protected Multiplier getDexMultiplier() {
        // Todo
        return Multiplier.Low;
    }
}
