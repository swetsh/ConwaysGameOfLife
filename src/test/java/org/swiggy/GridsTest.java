package org.swiggy;

import org.junit.jupiter.api.Test;
import org.swiggy.states.AliveState;

import static org.junit.jupiter.api.Assertions.*;

class GridsTest {

    @Test
    void testLocationNotFound() {
        assertNull(Grids.getInstance().location(new Cell(new AliveState())));
    }

    @Test
    void testSingletonInstance() {
        Grids anotherInstance = Grids.getInstance();

        assertSame(Grids.getInstance(), anotherInstance);
    }

    @Test
    void testAddLocation() {
        Coordinate coordinate = new Coordinate(1, 1);
        Cell cell =new Cell(new AliveState());

        Grids.getInstance().AddLocation(coordinate, cell);

        assertEquals(coordinate, Grids.getInstance().location(cell));
    }

    @Test
    void testGettingCellFromCoordinate() {
        Coordinate coordinate = new Coordinate(1, 1);
        Cell cell =new Cell(new AliveState());

        Grids.getInstance().AddLocation(coordinate, cell);

        assertEquals(cell, Grids.getInstance().cell(coordinate));
    }
}