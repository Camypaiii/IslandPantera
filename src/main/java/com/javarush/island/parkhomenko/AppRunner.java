package com.javarush.island.parkhomenko;

import com.javarush.island.parkhomenko.entyties.map.Cell;
import com.javarush.island.parkhomenko.entyties.map.IslandMap;
import com.javarush.island.parkhomenko.entyties.predators.Wolf;

public class AppRunner {
    public static void main(String[] args) {
        System.out.println("Start");
        IslandMap map = new IslandMap(5, 5);
        Cell[][] cells = map.getCells();



        for (int row = 0; row < cells.length; row++) {
            for (int coll = 0; coll < cells[row].length; coll++) {
                cells[row][coll] = new Cell();
                if (row % 2 == 0 && coll % 2 == 0){
                    cells[row][coll].addResident(new Wolf());
                }

                    System.out.print(cells[row][coll]+"   ");
            }
            System.out.println();
        }

    }
}
