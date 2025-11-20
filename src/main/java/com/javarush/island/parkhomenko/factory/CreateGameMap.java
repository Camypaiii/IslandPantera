package com.javarush.island.parkhomenko.factory;

import com.javarush.island.parkhomenko.entyties.herbivorous.Horse;
import com.javarush.island.parkhomenko.entyties.herbivorous.Rabbit;
import com.javarush.island.parkhomenko.entyties.map.Cell;
import com.javarush.island.parkhomenko.entyties.map.IslandMap;
import com.javarush.island.parkhomenko.entyties.plants.Grass;
import com.javarush.island.parkhomenko.entyties.predators.Wolf;

public class CreateGameMap {
    private final IslandMap map;


    public CreateGameMap(int row, int coll) {
        this.map = new IslandMap(row, coll);
        fillMap(map);
    }

    private void fillMap(IslandMap map) {
        Cell[][] cells = map.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int coll = 0; coll < cells[row].length; coll++) {
                cells[row][coll] = new Cell(row, coll);
                if (row % 2 == 0 && coll % 2 == 0) {
                    cells[row][coll].addResident(new Wolf());
                    cells[row][coll].addResident(new Rabbit());
                    cells[row][coll].addResident(new Grass());
                    cells[row][coll].addResident(new Horse());

                }
            }
        }
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                value.fillNextMove(map);
            }
        }
    }

    public IslandMap getMap() {
        return map;
    }
}
