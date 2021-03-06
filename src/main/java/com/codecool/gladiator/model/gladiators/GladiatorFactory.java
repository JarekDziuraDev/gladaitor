package com.codecool.gladiator.model.gladiators;

import com.codecool.gladiator.util.RandomUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class GladiatorFactory {

    private List<String> names;

    public GladiatorFactory(String fileOfNames) {
        try {
            File file = new File ("src/main/resources/Names.txt");//(getClass().getClassLoader().getResource(fileOfNames).getFile());
            names = Files.readAllLines(file.toPath());
        } catch (IOException|NullPointerException e) {
            System.out.println("Names file not found or corrupted!");
            System.exit(1);
        }
    }

    /**
     * Picks a random name from the file given in the constructor
     *
     * @return gladiator name
     */
    private String getRandomName() {
        // Todo
        String str = "";
        int random = RandomUtils.getRandomValue(1, names.size());
        return names.get(random);
    }

    /**
     * Instantiates a new gladiator with random name and type.
     * Creating an Archer, an Assassin, or a Brutal has the same chance,
     * while the chance of creating a Swordsman is the double of the chance of creating an Archer.
     * @return new Gladiator
     */
    public Gladiator generateRandomGladiator() {
        // Todo
        int type = RandomUtils.getRandomValue(1,125);

        if(type <= 25) {
            type = 0;
        } else if(type <= 50) {
            type = 1;
        } else if(type <= 75) {
            type = 2;
        } else if(type <= 125) {
            type = 3;
        } else {
            type = -1;
        }

        int baseHp = RandomUtils.getRandomValue(25, 100);
        int baseSp = RandomUtils.getRandomValue(25, 100);
        int baseDex = RandomUtils.getRandomValue(25, 100);
        int level = RandomUtils.getRandomValue(1, 5);

        String randomName = getRandomName();

        Gladiator resultGladiator;
        switch(type) {
            case 0: resultGladiator = new Brutal(randomName, baseHp, baseSp, baseDex, level); break;
            case 1: resultGladiator = new Assassin(randomName, baseHp, baseSp, baseDex, level); break;
            case 2: resultGladiator = new Archer(randomName, baseHp, baseSp, baseDex, level); break;
            case 3: resultGladiator = new Swordsman(randomName, baseHp, baseSp, baseDex, level); break;
            default: resultGladiator = null;
        }

        return resultGladiator;
    }
}
