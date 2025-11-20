package com.javarush.island.parkhomenko.entyties.herbivorous;

import com.javarush.island.parkhomenko.entyties.Animal;

public abstract class Herbivorous extends Animal {

    public Herbivorous(String name, String icon, int maxStep, int maxCountInCell, double needFoodKg, double weight) {
        super(name, icon, maxStep, maxCountInCell, needFoodKg, weight);
    }
}
