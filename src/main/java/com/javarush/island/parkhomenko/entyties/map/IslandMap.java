package com.javarush.island.parkhomenko.entyties.map;

import com.javarush.island.parkhomenko.entyties.Resident;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IslandMap {
    private final Cell[][] cells;
    private final Map<String, Integer> allStatistic = new HashMap<>();

    public IslandMap(int row, int col) {
        this.cells = new Cell[row][col];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Map<String, Integer> getAllStatistic() {
        return allStatistic;
    }

    public void updateStatistic() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Map<String, List<Resident>> residents = cell.getResidents();
                Set<String> keys = residents.keySet();
                for (String key : keys) {
                    if (allStatistic.containsKey(key)) {
                        int value = allStatistic.get(key) + residents.get(key).size();
                        allStatistic.put(key, value);
                    } else {
                        allStatistic.put(key, residents.get(key).size());
                    }
                }
            }
        }
    }
}
