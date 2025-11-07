package com.javarush.island.parkhomenko.entyties.map;

public class IslandMap {
    private final Cell[][] cells;

    public IslandMap(int row, int col) {
        this.cells = new Cell[row][col];
    }

    public Cell[][] getCells() {
        return cells;
    }
}
