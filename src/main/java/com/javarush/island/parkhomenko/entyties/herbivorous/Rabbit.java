package com.javarush.island.parkhomenko.entyties.herbivorous;

public class Rabbit extends Herbivorous {

    private String name;
    private String icon;

    public Rabbit() {
        this.name = "Rabbit";
        this.icon = "\uD83D\uDC07";
    }

    public Rabbit(String name, String icon) {
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
