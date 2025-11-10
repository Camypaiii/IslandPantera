package com.javarush.island.parkhomenko.entyties.plants;

public class Grass extends Plant{
    private String name;
    private String icon;

    public Grass() {
        this.name = "Grass";
        this.icon = "\uD83C\uDF40";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIcon() {
        return icon;
    }
}
