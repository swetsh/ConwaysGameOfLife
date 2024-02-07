package org.swiggy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.swiggy.exceptions.InvalidDimensionException;
import org.swiggy.exceptions.InvalidSeedValueException;
import org.swiggy.states.AliveState;
import org.swiggy.states.DeadState;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BoardTest {
    private Grids grids;

    @BeforeEach
    void setUp() {
        grids = Grids.getInstance();
    }


    @Test
    public void TestBoardWithNegativeDimensionExpectedRuntime() {
        assertThrows(InvalidDimensionException.class, () -> new Board(-2, -2, 0));
    }

    @Test
    public void TestBoardWithZeroDimensionExpectedRuntime() {
        assertThrows(InvalidDimensionException.class, () -> new Board(0, 2, 0));
    }

    @Test
    public void TestBoardWithNegativeSeedExpectedRuntime() {
        assertThrows(InvalidSeedValueException.class, () -> new Board(2, 2, -0.1));
    }

    @Test
    public void TestBoardWithSeedGreaterThan1ExpectedRuntime() {
        assertThrows(InvalidSeedValueException.class, () -> new Board(2, 2, -1.1));
    }

    @Test
    public void Test2x2BoardWithAllDeadCell() {
        Board board = new Board(2, 2, 0); //Zero seed value represent all dead cell

        String expectedBoard = "--\n--\n";

        assertEquals(expectedBoard, board.toString());
    }

    @Test
    public void Test2x2BoardWithAllAliveCell() {
        Board board = new Board(2, 2, 1); //One seed value represent all alive cell

        String expectedBoard = "**\n**\n";

        assertEquals(expectedBoard, board.toString());
    }

    @Test
    public void testBoardWith60PercentAliveCell() {
        Board board = new Board(10, 10, 0.6);

        String boardString = board.toString();

        long aliveCount = boardString.chars().filter(ch -> ch == '*').count();

        assertTrue(Math.abs(aliveCount-60) < 10);
    }

    @Test
    public void testBoardWith20PercentAliveCell() {
        Board board = new Board(10, 10, 0.2);

        String boardString = board.toString();

        long aliveCount = boardString.chars().filter(ch -> ch == '*').count();

        assertTrue(Math.abs(aliveCount-20) < 10);
    }

    @Test
    public void testIsAllDeadShouldBeTrueWhenAllCellsAreDead() {
        Board board = new Board(2, 2, 0);

        assertTrue(board.isAllDead());
    }

    @Test
    public void testIsAllDeadShouldBeFalseWhenAllCellsAreAlive() {
        Board board = new Board(2, 2, 1);

        assertFalse(board.isAllDead());
    }

    @Test
    public void testIsAllDeadShouldBeFalseWhenFewCellsAreAlive() {
        Board board = new Board(10, 10, 0.3);

        assertFalse(board.isAllDead());
    }

    @Test
    public void testIsAllDeadShouldBeTrueWhenAllCellsAreAliveAndItsEvolvedOnce() {
        Board board = new Board(2, 2, 1);
        board.evolve();

        assertTrue(board.isAllDead());
    }

    @Test
    public void testIfAliveCountIsZeroIsAllDeadShouldGiveTrueFor100IterationsAndSeed0() {

        Board board = new Board(4, 4,0);

        for (int i=0; i<100; i++) {
            long aliveCount = board.toString().chars().filter(ch -> ch == '*').count();
            if (aliveCount == 0)
                assertTrue(board.isAllDead());
            else
                assertFalse(board.isAllDead());
            board.evolve();
        }
    }

    @Test
    public void testIfAliveCountIsZeroIsAllDeadShouldGiveTrueFor100IterationsAndSeed40Percent() {

        Board board = new Board(4, 4,0.4);

        for (int i=0; i<100; i++) {
            long aliveCount = board.toString().chars().filter(ch -> ch == '*').count();
            if (aliveCount == 0)
                assertTrue(board.isAllDead());
            else
                assertFalse(board.isAllDead());
            board.evolve();
        }
    }


    @Test
    public void testIfAliveCountIsZeroIsAllDeadShouldGiveTrueFor100IterationsAndSeed100Percent() {

        Board board = new Board(4, 4,1);

        for (int i=0; i<100; i++) {
            long aliveCount = board.toString().chars().filter(ch -> ch == '*').count();
            if (aliveCount == 0)
                assertTrue(board.isAllDead());
            else
                assertFalse(board.isAllDead());
            board.evolve();
        }
    }

}