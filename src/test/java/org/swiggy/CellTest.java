package org.swiggy;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CellTest {

    private Grids grids;

    @BeforeEach
    void setUp() {
        grids = Grids.getInstance();
    }


    @Test
    public void TestCountIsZeroIfAllNeighboursAreDead() {
        grids.AddLocation(new Coordinate(0,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(0,1), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(0,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(1,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(1,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,1), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,2), new Cell(new DeadState()));

        Cell cell = new Cell(new DeadState());

        grids.AddLocation(new Coordinate(1,1), cell);

        assertEquals(0, cell.neighboursCount(3,3));
    }

    @Test
    public void TestCountIsNot8IfAllNeighboursAreAliveButProvidedWrongRow() {
        grids.AddLocation(new Coordinate(0,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(1,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(1,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,1), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,2), new Cell(new DeadState()));

        Cell cell = new Cell(new DeadState());

        grids.AddLocation(new Coordinate(1,1), cell);

        assertNotEquals(3, cell.neighboursCount(2,3));
    }


    @Test
    public void TestCountIs8IfAllNeighboursAreAlive() {
        grids.AddLocation(new Coordinate(0,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,2), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(1,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(1,2), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(2,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(2,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(2,2), new Cell(new AliveState()));

        Cell cell = new Cell(new DeadState());

        grids.AddLocation(new Coordinate(1,1), cell);

        assertEquals(8, cell.neighboursCount(3,3));
    }
    @Test
    public void TestCountIs3If3NeighboursAreAlive() {
        grids.AddLocation(new Coordinate(0,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(1,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(1,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,1), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,2), new Cell(new DeadState()));

        Cell cell = new Cell(new DeadState());

        grids.AddLocation(new Coordinate(1,1), cell);

        assertEquals(3, cell.neighboursCount(3,3));
    }


}
