package com.javarush.island.parkhomenko.entyties;

import com.javarush.island.parkhomenko.entyties.map.Cell;
import com.javarush.island.parkhomenko.utils.Rnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Animal extends Resident {

    private final double needFoodKg;

    public Animal(String name, String icon, int maxStep, int maxCountInCell, double needFoodKg, double weight) {
        super(name, icon, maxStep, maxCountInCell, weight);
        this.needFoodKg = needFoodKg;
    }

    public double getNeedFoodKg() {
        return needFoodKg;
    }

    @Override
    public void move(Cell cell) {
        Cell cellStart = cell;
        Cell cellFinish = cell;
        List<Cell> passedSteps = new ArrayList<>();
        int maxStep = this.getMaxStep();
        int steps = Rnd.random(maxStep);

        for (int i = 0; i < steps; i++) {
            List<Cell> nextMove = cellStart.getNextMove();
            passedSteps.add(cellStart);
            do {
                cellFinish = nextMove.get(Rnd.random(nextMove.size()-1));
            }
            while (passedSteps.contains(cellFinish));
            cellStart = cellFinish;
        }

        cellFinish.addResident(this);
        cell.killResident(this);
    }

    @Override
    public void reproduce(Cell cell) {
        Map<String, List<Resident>> residents = cell.getResidents();
        Set<Map.Entry<String, List<Resident>>> entries = residents.entrySet();
        for (Map.Entry<String, List<Resident>> entry : entries) {
            List<Resident> residentList = entry.getValue();
            if (residentList.size() > 1) {
                Resident resident = residentList.getFirst();
                if (residentList.size() < resident.getMaxCountInCell()) {
                    residentList.add(resident.clone());
                }
            }
        }
    }
}
