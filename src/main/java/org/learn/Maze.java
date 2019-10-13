package org.learn;

/**
 * Created by vinay on 24/2/18.
 */
public class Maze {

    private int totalRows;
    private int totalCols;

    private int[][] mazeData;

    public Cell[][] getMaze() {
        return maze;
    }

    public void setMaze(Cell[][] maze) {
        this.maze = maze;
    }

    public Cell getSourceCell() {
        //return maze[this.getSourceCell().getX()][this.getSourceCell().getY()];
        return sourceCell;
    }

    public void setSourceCell(Cell sourceCell) {
        this.sourceCell = sourceCell;
    }

    public Cell getTargetCell() {
        //return maze[this.getTargetCell().getX()][this.getTargetCell().getY()];
        return targetCell;
    }

    public void setTargetCell(Cell targetCell) {
        this.targetCell = targetCell;
    }

    private Cell[][] maze;
    private Cell sourceCell;
    private Cell targetCell;

    public Maze() {
    }

    public Maze(int rows, int cols, int[][] maze) {
        this.totalRows = rows;
        this.totalCols = cols;
        this.mazeData = maze;
    }

    public int getHeiht() {
        return totalRows;
    }

    public int getWidth() {
        return totalCols;
    }

    public void setTotalRows(int rows) {
        this.totalRows = rows;
    }

    public void setTotalCols(int cols) {
        this.totalCols = cols;
    }

    public int[][] getMazeData() {
        return mazeData;
    }

    public Cell getCellAt(int x, int y) {
        return maze[x][y];
    }

}
