package com.javarush.island.parkhomenko.entyties.predators;

public class Wolf extends Predator{

    private String name;
    private String icon;

    public Wolf() {
        this.name = "Wolf";
        this.icon = "\uD83D\uDC3A";
    }

    public Wolf(String name, String icon) {
        super(name, icon);
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
