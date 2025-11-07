package com.javarush.island.parkhomenko.entyties.predators;

import com.javarush.island.parkhomenko.entyties.Animal;

public abstract class Predator extends Animal {

    public Predator() {
    }

    public Predator(String name, String icon) {
        super(name, icon);
    }
}
