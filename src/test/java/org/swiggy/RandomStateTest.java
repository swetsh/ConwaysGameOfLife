package org.swiggy;

import org.junit.jupiter.api.Test;
import org.swiggy.states.AliveState;
import org.swiggy.states.CellState;
import org.swiggy.states.DeadState;

import static org.junit.jupiter.api.Assertions.*;

class RandomStateTest {
    @Test
    public void testRandomStateIsNotNull() {
        CellState cellState = new RandomState(0.4).state;

        assertNotNull(cellState);
    }
    @Test
    public void testRandomStateIsAliveForSeed1() {
        CellState cellState = new RandomState(1).state;

        assertInstanceOf(AliveState.class, cellState);
    }
    @Test
    public void testRandomStateIsDeadForSeed0() {
        CellState cellState = new RandomState(0).state;

        assertInstanceOf(DeadState.class, cellState);
    }
}