package org.swiggy.states;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadStateTest {
    @Test
    public void testStateValueShouldBe0() {
        DeadState deadState = new DeadState();
        assertEquals(0, deadState.value());
    }

    @Test
    public void testCellShouldBeDiedWithZeroNeighbours() {
        DeadState deadState = new DeadState();
        assertInstanceOf(DeadState.class, deadState.nextState(0));
    }
    @Test
    public void testCellShouldBeDiedWith8Neighbours() {
        DeadState deadState = new DeadState();
        assertInstanceOf(DeadState.class, deadState.nextState(8));
    }
    @Test
    public void testCellShouldGetAliveWith3Neighbours() {
        DeadState deadState = new DeadState();
        assertInstanceOf(AliveState.class, deadState.nextState(3));
    }
    @Test
    public void testCellShouldBeDiedWith2Neighbours() {
        DeadState deadState = new DeadState();
        assertInstanceOf(DeadState.class, deadState.nextState(2));
    }
}