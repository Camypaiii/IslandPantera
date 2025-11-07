package com.javarush.island.parkhomenko.entyties;

public abstract class Resident {
    private String name;
    private String icon;

    public Resident() {

    }

    public Resident(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return icon;
    }
}
