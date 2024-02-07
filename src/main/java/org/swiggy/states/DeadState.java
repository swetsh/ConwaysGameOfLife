package org.swiggy.states;

public class DeadState implements CellState {
    @Override
    public CellState nextState(int neighbourCount) {
        if (neighbourCount == 3)
            return new AliveState();
        return new DeadState();
    }

    @Override
    public int value() {
        return 0;
    }

    @Override
    public String toString() {
        return "-";
    }
}
