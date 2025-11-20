package com.javarush.island.parkhomenko.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Rnd {

    public static int random(int max) {
        return ThreadLocalRandom.current().nextInt(max + 1);
    }
}
