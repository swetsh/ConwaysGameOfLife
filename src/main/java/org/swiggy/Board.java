package org.swiggy;

import org.swiggy.exceptions.InvalidSeedValueException;
import org.swiggy.exceptions.InvalidDimensionException;

public class Board {
    private int rows;
    private int columns;

    public Board(int rows, int columns, double seed) {
        if (rows <= 0 || columns <= 0) throw new InvalidDimensionException();
        if (seed < 0 || seed > 1) throw new InvalidSeedValueException();

        this.rows = rows;
        this.columns = columns;
        for (int i=0; i<this.rows; i++) {
            for(int j=0; j<this.columns; j++) {
                double randomValue = Math.random();
                CellState state = (randomValue < seed) ? new AliveState() : new DeadState();
                Grids.getInstance().AddLocation(new Coordinate(i, j), new Cell(state));
            }
        }
    }

    public void evolve() {
        int[][] neighboursGrid = new int[rows][columns];
        for (int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                neighboursGrid[i][j] = Grids.getInstance().cell(new Coordinate(i, j)).neighboursCount(rows, columns);
            }
        }
        for (int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                Grids.getInstance().cell(new Coordinate(i, j)).update(neighboursGrid[i][j]);
            }
        }
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