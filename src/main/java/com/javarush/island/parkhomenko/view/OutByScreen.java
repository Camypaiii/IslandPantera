package com.javarush.island.parkhomenko.view;

import com.javarush.island.parkhomenko.entyties.map.Cell;
import com.javarush.island.parkhomenko.entyties.map.IslandMap;

public class OutByScreen {

    private IslandMap map;
    private Cell[][] cells;

    public OutByScreen(IslandMap map) {
        this.map = map;
        this.cells = map.getCells();
    }

    public void showMap(){
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

    }

    public void showInfo(){
        map.updateStatistic();
        System.out.println(map.getAllStatistic());

    }


}
