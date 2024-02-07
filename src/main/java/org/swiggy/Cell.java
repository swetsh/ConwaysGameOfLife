package org.swiggy;

import org.swiggy.states.CellState;

public class Cell {
    private CellState currentState;

    public Cell(CellState cellState) {
        currentState = cellState;
    }

    @Override
    public String toString(){
        return currentState.toString();
    }

    public int neighboursCount(int rows, int columns) {
        int count = 0;
        int[][] positions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},            {0, 1},
                {1, -1},  {1, 0},  {1, 1}
        };

        Coordinate coordinate = Grids.getInstance().location(this);

        for (int i = 0; i < 8; i++) {
            int newRow = (coordinate.x() + positions[i][0] + rows) % rows;
            int newColumn = (coordinate.y() + positions[i][1] + columns) % columns;
            count += Grids.getInstance().cell(new Coordinate(newRow, newColumn)).currentState.value();
        }
        return count;
    }

    public void update(int aliveNeighbours) {
        currentState = currentState.nextState(aliveNeighbours);
    }
}
