package org.swiggy.states;

public interface CellState {
    CellState nextState(int neighbourCount);
    int value();
}
