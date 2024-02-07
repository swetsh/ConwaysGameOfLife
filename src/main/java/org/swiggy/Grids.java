package org.swiggy;

import org.swiggy.exceptions.CellDoesNotExistException;
import org.swiggy.exceptions.CoordinateDoesNotExistException;

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

    public void AddLocation(Coordinate coordinate, Cell cell) throws IllegalArgumentException {
        cells.put(coordinate, cell);
        locations.put(cell, coordinate);
    }

    public Cell cell(Coordinate coordinate) throws IllegalArgumentException {
        Cell cell = cells.get(coordinate);
        if (cell == null) {
            throw new CoordinateDoesNotExistException();
        }
        return cell;
    }

    public Coordinate location(Cell cell) throws IllegalArgumentException {
        Coordinate coordinate = locations.get(cell);
        if (coordinate == null) {
            throw new CellDoesNotExistException();
        }
        return coordinate;
    }

}