package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AliveStateTest {
    @Test
    public void testStateValueShouldBe1() {
        AliveState aliveState = new AliveState();
        assertEquals(1, aliveState.value());
    }

    @Test
    public void testCellShouldDieWithZeroNeighbours() {
        AliveState aliveState = new AliveState();
        assertInstanceOf(DeadState.class, aliveState.nextState(0));
    }
    @Test
    public void testCellShouldDieWith8Neighbours() {
        AliveState aliveState = new AliveState();
        assertInstanceOf(DeadState.class, aliveState.nextState(8));
    }
    @Test
    public void testCellShouldNotDieWith3Neighbours() {
        AliveState aliveState = new AliveState();
        assertInstanceOf(AliveState.class, aliveState.nextState(3));
    }
    @Test
    public void testCellShouldNotDieWith2Neighbours() {
        AliveState aliveState = new AliveState();
        assertInstanceOf(AliveState.class, aliveState.nextState(2));
    }
}