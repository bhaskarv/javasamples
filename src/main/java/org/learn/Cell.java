package org.learn;

/**
 * Created by vinay on 24/2/18.
 */
public class Cell {
    private int x;
    private int y;
    private char cellValue;
    private boolean isVisited;
    private boolean isInSolutionPath;
    private boolean isWall;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isInSolutionPath() {
        return isInSolutionPath;
    }

    public void setInSolutionPath(boolean inSolutionPath) {
        isInSolutionPath = inSolutionPath;
    }

    public boolean isWall() {
        return isWall;
    }

    public void setWall(boolean wall) {
        isWall = wall;
    }

    public char getCellValue() {
        return cellValue;
    }

    public void setCellValue(char cellValue) {
        this.cellValue = cellValue;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Cell cell) {
        return (cell.getX() == this.x && cell.getY() == this.getY());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = (prime * result) + x;
        result = (prime * result) + y;

        return result;
    }
}
