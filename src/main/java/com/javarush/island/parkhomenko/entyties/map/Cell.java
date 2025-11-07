package com.javarush.island.parkhomenko.entyties.map;

import com.javarush.island.parkhomenko.entyties.Resident;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cell {
    private int row;
    private int coll;
    private List<Resident> residents = new ArrayList<>();

    public Cell() {

    }

    public int getRow() {
        return row;
    }

    public int getColl() {
        return coll;
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public void addResident(Resident resident) {
        this.residents.add(resident);
    }

    public void killResident(Resident resident) {
        this.residents.remove(resident);
    }

    @Override
    public String toString() {
        if(residents.isEmpty()) {
            return "...";
        }
        return residents.stream()
                .map(r -> r.getIcon())
                .collect(Collectors.joining());
    }
}
