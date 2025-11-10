package com.javarush.island.parkhomenko.entyties.map;

import com.javarush.island.parkhomenko.entyties.Resident;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cell {
    private int row;
    private int coll;
    private final Map<String, List<Resident>> residents = new HashMap<>();
    private List<Cell> nextMove;

    public Cell(int row, int coll) {
        this.row = row;
        this.coll = coll;
    }

    public int getRow() {
        return row;
    }

    public int getColl() {
        return coll;
    }

    public Map<String, List<Resident>> getResidents() {
        return residents;
    }

    public void addResident(Resident resident) {
        String key = resident.getName();
        if (residents.containsKey(key)) {
            List<Resident> currentList = residents.get(key);
            currentList.add(resident);
        } else {
            List<Resident> currentList = new ArrayList<>();
            currentList.add(resident);
            residents.put(key, currentList);
        }
    }

    public void killResident(Resident resident) {
        String key = resident.getName();
        if (residents.containsKey(key)) {
            List<Resident> currentList = residents.get(key);
            if (!currentList.isEmpty()) {
                currentList.remove(resident);
            }
        }
    }

    @Override
    public String toString() {
        if (residents.isEmpty()) {
            return "......";
        }
        return residents.values()
                .stream()
                .filter(list -> !list.isEmpty())
                .map(r -> r.stream()
                        .findAny()
                        .get()
                        .getIcon())
                .collect(Collectors.joining());
    }
}
