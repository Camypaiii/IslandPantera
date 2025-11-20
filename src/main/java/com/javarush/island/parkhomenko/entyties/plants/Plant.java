package com.javarush.island.parkhomenko.entyties.plants;

import com.javarush.island.parkhomenko.entyties.Resident;
import com.javarush.island.parkhomenko.entyties.map.Cell;

public abstract class Plant extends Resident {

    public Plant(String name, String icon, int maxStep, int maxCountInCell, double weight) {
        super(name, icon, maxStep, maxCountInCell, weight);
    }

    @Override
    public void move(Cell cell) {

    }

    @Override
    public void reproduce(Cell cell) {

    }
}
