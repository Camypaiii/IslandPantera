package com.javarush.island.parkhomenko.entyties;

import com.javarush.island.parkhomenko.api.Moveable;
import com.javarush.island.parkhomenko.api.Reproducible;

public abstract class Resident implements Moveable, Reproducible, Cloneable {
    private final String name;
    private final String icon;
    private final int maxStep;
    private final int maxCountInCell;
    private double weight;

    public Resident(String name, String icon, int maxStep, int maxCountInCell, double weight) {
        this.name = name;
        this.icon = icon;
        this.maxStep = maxStep;
        this.maxCountInCell = maxCountInCell;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public int getMaxStep() {
        return maxStep;
    }

    @Override
    public String toString() {
        return icon;
    }

    public int getMaxCountInCell() {
        return maxCountInCell;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Resident clone() {
        try {
            Resident clone = (Resident) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
