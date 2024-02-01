package org.swiggy;

public interface CellState {
    CellState nextState(int neighbourCount);
    int value();
}
