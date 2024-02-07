package org.swiggy;

import org.swiggy.states.AliveState;
import org.swiggy.states.CellState;
import org.swiggy.states.DeadState;

public class RandomState {
    public final CellState state;

    public RandomState(double seed) {
        double randomValue = Math.random();
        state = (randomValue < seed) ? new AliveState() : new DeadState();
    }
}
