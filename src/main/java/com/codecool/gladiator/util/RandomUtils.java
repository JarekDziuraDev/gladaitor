package com.codecool.gladiator.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static int getRandomValue(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

}
