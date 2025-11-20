package com.javarush.island.parkhomenko.entyties.map;

import com.javarush.island.parkhomenko.entyties.Resident;

import java.util.*;
import java.util.stream.Collectors;

public class Cell {
    private final int row;
    private final int coll;
    private final Map<String, List<Resident>> residents = new HashMap<>();
    private final List<Cell> nextMove = new ArrayList<>();

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

    public List<Resident> getAllResidentsCell(){
        List<Resident> allResidentsCell = new ArrayList<>();
        Set<Map.Entry<String, List<Resident>>> entries = residents.entrySet();

        for (Map.Entry<String, List<Resident>> entry : entries){
            List<Resident> list = entry.getValue();
            allResidentsCell.addAll(list);
        }
        return allResidentsCell;
    }


    public void fillNextMove(IslandMap map) {
        Cell[][] cells = map.getCells();
        if (row > 0) {
            nextMove.add(cells[row - 1][coll]);
        }
        if (coll > 0) {
            nextMove.add(cells[row][coll - 1]);
        }
        if (row < map.getRows() - 1) {
            nextMove.add(cells[row + 1][coll]);
        }
        if (coll < map.getColls()-1) {
            nextMove.add(cells[row][coll + 1]);
        }
    }

    public List<Cell> getNextMove() {
        return nextMove;
    }

    public void addResident(Resident resident) {
        String key = resident.getName();
        if (residents.containsKey(key)) {
            List<Resident> currentList = residents.get(key);
            if (currentList.size() < resident.getMaxCountInCell()) {
                currentList.add(resident);
            }
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
            return "";
        }
        return residents.values()
                .stream()
                .filter(list -> !list.isEmpty())
                .sorted((l1, l2) -> l2.size() - l1.size())
                .limit(3)
                .map(r -> r.stream()
                        .findAny()
                        .get()
                        .getIcon())
                .collect(Collectors.joining());
    }
}
