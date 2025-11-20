package com.javarush.island.parkhomenko;

import com.javarush.island.parkhomenko.entyties.Resident;
import com.javarush.island.parkhomenko.entyties.map.Cell;
import com.javarush.island.parkhomenko.entyties.map.IslandMap;
import com.javarush.island.parkhomenko.factory.CreateGameMap;
import com.javarush.island.parkhomenko.view.OutByScreen;

import java.util.List;

public class AppRunner {
    public static void main(String[] args) {

        IslandMap map = new CreateGameMap(5, 5).getMap();
        OutByScreen view = new OutByScreen(map);

        view.showMap();
        view.showInfo();

        Cell[][] cells = map.getCells();
        for (Cell[] cell : cells) {
            for (Cell curentCell : cell) {
                List<Resident> allResidentsCell = curentCell.getAllResidentsCell();
                allResidentsCell.forEach(r -> r.move(curentCell));
            }
        }

        for (Cell[] cell : cells) {
            for (Cell curentCell : cell) {
                List<Resident> allResidentsCell = curentCell.getAllResidentsCell();
                allResidentsCell.forEach(r -> r.reproduce(curentCell));
            }
        }

        view.showMap();
        view.showInfo();


    }


}