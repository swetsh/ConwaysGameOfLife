package org.swiggy;

import java.util.HashMap;
import java.util.Map;

public class Grids {
    private static Grids INSTANCE = new Grids();

    private final Map<Coordinate, Cell> cells;
    private final Map<Cell, Coordinate> locations;

    private Grids() {
        cells = new HashMap<>();
        locations = new HashMap<>();
    }

    public static Grids getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Grids();
        }
        return INSTANCE;
    }

    public void AddLocation(Coordinate coordinate, Cell cell) {
        cells.put(coordinate, cell);
        locations.put(cell, coordinate);
    }

    public Cell cell(Coordinate coordinate) {
        return cells.get(coordinate);
    }

    public Coordinate location(Cell cell) {
        return locations.get(cell);
    }
}