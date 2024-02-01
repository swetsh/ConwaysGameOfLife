package org.swiggy;

public class AliveState implements CellState {
    @Override
    public CellState nextState(int neighbourCount) {
        if (neighbourCount == 2 || neighbourCount == 3)
            return new AliveState();
        return new DeadState();
    }

    @Override
    public int value() {
        return 1;
    }

    @Override
    public String toString() {
        return "*";
    }
}
