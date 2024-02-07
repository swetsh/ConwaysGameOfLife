package org.swiggy;

import org.junit.jupiter.api.*;
import org.swiggy.states.AliveState;
import org.swiggy.states.DeadState;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest {

    private Grids grids;

    @BeforeEach
    void setUp() {
        grids = Grids.getInstance();
    }

    @Test
    public void testUpdateShouldReturn0IfADeadCellHasAllDeadNeighbours() {
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

        cell.neighboursCount(3,3);

        assertEquals(0, cell.update());
    }


    @Test
    public void TestUpdateShouldReturn0IfADeadCellsAllNeighboursAreAlive() {
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

        cell.neighboursCount(3,3);

        assertEquals(0, cell.update());
    }

    @Test
    public void testUpdateShouldReturnMinus1IfAnAliveCellHasAllDeadNeighbours() {
        grids.AddLocation(new Coordinate(0,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(0,1), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(0,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(1,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(1,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,1), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,2), new Cell(new DeadState()));

        Cell cell = new Cell(new AliveState());
        grids.AddLocation(new Coordinate(1,1), cell);

        cell.neighboursCount(3,3);

        assertEquals(-1, cell.update());
    }

    @Test
    public void testUpdateShouldReturn1IfADeadCellHas3AliveNeighbours() {
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

        cell.neighboursCount(3,3);

        assertEquals(1, cell.update());
    }

    @Test
    public void testUpdateShouldReturn0IfAnAliveCellHas3AliveNeighbours() {
        grids.AddLocation(new Coordinate(0,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(1,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(1,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,1), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,2), new Cell(new DeadState()));

        Cell cell = new Cell(new AliveState());
        grids.AddLocation(new Coordinate(1,1), cell);

        cell.neighboursCount(3,3);

        assertEquals(0, cell.update());
    }

    @Test
    public void testUpdateShouldReturn0IfAnAliveCellHas2AliveNeighbours() {
        grids.AddLocation(new Coordinate(0,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(0,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(1,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(1,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,1), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,2), new Cell(new DeadState()));

        Cell cell = new Cell(new AliveState());
        grids.AddLocation(new Coordinate(1,1), cell);

        cell.neighboursCount(3,3);

        assertEquals(0, cell.update());
    }

    @Test
    public void testUpdateShouldReturn0IfAnDeadCellHas2AliveNeighbours() {
        grids.AddLocation(new Coordinate(0,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(0,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(1,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(1,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,1), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,2), new Cell(new DeadState()));

        Cell cell = new Cell(new DeadState());
        grids.AddLocation(new Coordinate(1,1), cell);

        cell.neighboursCount(3,3);

        assertEquals(0, cell.update());
    }


    @Test
    public void TestUpdateShouldReturnMinus1IfAnAliveCellsAllNeighboursAreAlive() {
        grids.AddLocation(new Coordinate(0,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,2), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(1,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(1,2), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(2,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(2,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(2,2), new Cell(new AliveState()));

        Cell cell = new Cell(new AliveState());
        grids.AddLocation(new Coordinate(1,1), cell);

        cell.neighboursCount(3,3);

        assertEquals(-1, cell.update());
    }

    @Test
    public void TestUpdateShouldReturnMinus1IfAnAliveCellsHalfNeighboursAreAlive() {
        grids.AddLocation(new Coordinate(0,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(0,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(0,2), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(1,0), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(1,2), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(2,0), new Cell(new DeadState()));
        grids.AddLocation(new Coordinate(2,1), new Cell(new AliveState()));
        grids.AddLocation(new Coordinate(2,2), new Cell(new DeadState()));

        Cell cell = new Cell(new AliveState());
        grids.AddLocation(new Coordinate(1,1), cell);

        cell.neighboursCount(3,3);

        assertEquals(-1, cell.update());
    }

}
