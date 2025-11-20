package com.javarush.island.parkhomenko.entyties.predators;

import com.javarush.island.parkhomenko.entyties.Animal;

public abstract class Predator extends Animal {

    public Predator(String name, String icon, int maxStep, int maxCountInCell, double needFoodKg, double weight) {
        super(name, icon, maxStep, maxCountInCell, needFoodKg, weight);
    }
}
