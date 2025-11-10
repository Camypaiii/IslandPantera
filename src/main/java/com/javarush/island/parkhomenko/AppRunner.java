package com.javarush.island.parkhomenko;

import com.javarush.island.parkhomenko.entyties.herbivorous.Rabbit;
import com.javarush.island.parkhomenko.entyties.map.Cell;
import com.javarush.island.parkhomenko.entyties.map.IslandMap;
import com.javarush.island.parkhomenko.entyties.plants.Grass;
import com.javarush.island.parkhomenko.entyties.predators.Wolf;
import com.javarush.island.parkhomenko.view.OutByScreen;

public class AppRunner {
    public static void main(String[] args) {

        IslandMap map = new IslandMap(5, 5);
        OutByScreen view = new OutByScreen(map);
        fillMap(map);
        view.showMap();
        view.showInfo();
    }

    private static void fillMap(IslandMap map) {
        Cell[][] cells = map.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int coll = 0; coll < cells[row].length; coll++) {
                cells[row][coll] = new Cell(row, coll);
                if (row % 2 == 0 && coll % 2 == 0){
                    cells[row][coll].addResident(new Wolf());
                    cells[row][coll].addResident(new Rabbit());
                    cells[row][coll].addResident(new Grass());

                }
            }
        }
    }
}
