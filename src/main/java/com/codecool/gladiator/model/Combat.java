package com.codecool.gladiator.model;

import com.codecool.gladiator.model.gladiators.Gladiator;
import com.codecool.gladiator.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Combat class, used for simulating fights between pairs of gladiators
 */
public class Combat {

    private final Gladiator gladiator1;
    private final Gladiator gladiator2;

    private final List<String> combatLog;

    public Combat(Contestants contestants) {
        this.gladiator1 = contestants.gladiator1;
        this.gladiator2 = contestants.gladiator2;
        this.combatLog = new ArrayList<>();
    }

    /**
     * Simulates the combat and returns the winner.
     * If one of the opponents is null, the winner is the one that is not null
     * If both of the opponents are null, the return value is null
     *
     * @return winner of combat
     */
    private boolean checkGladiatorNullReference(Gladiator gladiator) {
        return gladiator == null;
    }
    private boolean checkGladiatorHPCondition(Gladiator gladiator) {
        return gladiator.getCurrentHpBy() <= 0;
    }
    private Gladiator checkNullReferenceAndHpValue(Gladiator gladiator1, Gladiator gladiator2) {
        Gladiator resultGladiato = null;
        if (checkGladiatorHPCondition(gladiator1))
            resultGladiato = gladiator2;
        if (checkGladiatorHPCondition(gladiator1))
            resultGladiato = gladiator1;

        return resultGladiato;
    }

    private void Attack(Gladiator gladiator1, Gladiator gladiator2) {
        double attackPoints = gladiator1.getMaxSp() * RandomUtils.getRandomValue(0.1, 0.5);
        gladiator2.decreaseHpBy( (int)attackPoints );

        getCombatLog(gladiator1.getName() + " deals " + attackPoints + " damage");
    }

    public Gladiator simulate() {
        // Todo
        Gladiator winner = null;
        Gladiator gladiatorAttacker, gladiatorDefender = null;

        if (checkGladiatorNullReference(getGladiator1()))
            return getGladiator2();
        else if (checkGladiatorNullReference(getGladiator2()))
            return getGladiator1();
        else {
            boolean fightCondition = true;

            while (fightCondition) {
                int gladiatorFirst = RandomUtils.getRandomValue(1,2);
                int chanceToAttack = 0;
                int percentValue = RandomUtils.getRandomValue(1,100);

                if (gladiatorFirst % 2 == 0) {
                    chanceToAttack = Math.abs((getGladiator2().getMaxDex() - getGladiator1().getMaxDex()) % 100);
                    gladiatorAttacker = getGladiator1();
                    gladiatorDefender = getGladiator2();
//                    if (chanceToAttack > percentValue) {
//
//                        //this.Attack(getGladiator1(), getGladiator2());
//                    }
                } else {
                    chanceToAttack = Math.abs((getGladiator1().getMaxDex() - getGladiator2().getMaxDex()) % 100);
                    gladiatorAttacker = getGladiator2();
                    gladiatorDefender = getGladiator1();
//                    if (chanceToAttack > percentValue) {
//
//                        //this.Attack(getGladiator2(), getGladiator1());
//                    }
                }
                if (chanceToAttack > percentValue) {
                    this.Attack(gladiatorAttacker, gladiatorDefender);
                } else this.getCombatLog(gladiatorAttacker.getName() + " missed.");

                if(checkGladiatorHPCondition(getGladiator1())) {
                    fightCondition = false;
                    winner = getGladiator2();
                }
                if(checkGladiatorHPCondition(getGladiator2())) {
                    fightCondition = false;
                    winner = getGladiator1();
                }
            }

        }



        return winner;
    }

    public Gladiator getGladiator1() {
        return gladiator1;
    }

    public Gladiator getGladiator2() {
        return gladiator2;
    }

    public String getCombatLog(String separator) {
        return String.join(separator, combatLog);
    }

}
