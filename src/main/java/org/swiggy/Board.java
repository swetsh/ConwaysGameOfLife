package org.swiggy;

import org.swiggy.exceptions.InvalidSeedValueException;
import org.swiggy.exceptions.InvalidDimensionException;
import org.swiggy.states.AliveState;
import org.swiggy.states.CellState;
import org.swiggy.states.DeadState;

public class Board {
    private final int rows;
    private final int columns;

    private int aliveCellCount;

    public Board(int rows, int columns, double seed) {
        if (rows <= 0 || columns <= 0) throw new InvalidDimensionException();
        if (seed < 0 || seed > 1) throw new InvalidSeedValueException();

        aliveCellCount = 0;

        this.rows = rows;
        this.columns = columns;
        for (int i=0; i<this.rows; i++) {
            for(int j=0; j<this.columns; j++) {
                CellState state = new RandomState(seed).state;

                if (state instanceof AliveState) aliveCellCount++;

                Grids.getInstance().AddLocation(new Coordinate(i, j), new Cell(state));
            }
        }
    }


    public void evolve() {
        for (int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                Grids.getInstance().cell(new Coordinate(i, j)).updateNeighbours(rows, columns);
            }
        }

        for (int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                aliveCellCount += Grids.getInstance().cell(new Coordinate(i, j)).update();
            }
        }
    }

    public boolean isAllDead() {
        return aliveCellCount == 0;
    }

    @Override
    public String toString() {
        StringBuilder board= new StringBuilder();
        for(int i=0; i<this.rows; i++) {
            for(int j=0; j<this.columns; j++) {
                board.append(Grids.getInstance().cell(new Coordinate(i, j)));
            }
            board.append("\n");
        }
        return board.toString();
    }

}
