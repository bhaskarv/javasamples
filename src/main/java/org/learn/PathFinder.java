package org.learn;

import java.util.*;

public class PathFinder {

    private Maze maze;

    private Stack<Cell> stack = new Stack<Cell>();
    private Set<Cell> visitedCells = new HashSet<Cell>();
    private Set<Cell> pathCells = new HashSet<Cell>();

    public PathFinder(Maze maze) {
        this.maze = maze;
    }

    public boolean solveMaze() {
        visitedCells.add(maze.getSourceCell());
        pathCells.add(maze.getSourceCell());
        stack.push(maze.getSourceCell());
        boolean solved =  solve();
        cleanup();
        return solved;
    }

    private boolean solve() {
        Cell currentCell = stack.peek();
        if (currentCell == null) {
            pathCells.clear();
            return false;
        } else {
            if (currentCell.equals(maze.getTargetCell())) {
                return true;
            } else {
                Cell nextCell = getNextValidCell(currentCell);
                if (nextCell != null && !nextCell.isWall()) {
                    markCellVisited(nextCell, true);
                } else {
                    markCellVisited(nextCell, false);
                    removeCellFromPath(nextCell);
                }
            }

        }
        return solve();
    }
    private void removeCellFromPath(Cell cell) {
        if (cell != null)
            cell.setCellValue(' ');
        pathCells.remove(cell);
    }

    private void markCellVisited(Cell cell, boolean addToPath) {
        if(cell != null && addToPath) {
            cell.setCellValue('X');
            pathCells.add(cell);
        }
        visitedCells.add(cell);
        stack.push(cell);

    }
    private Cell getNextValidCell(Cell currentCell) {
        int x = currentCell.getX();
        int y = currentCell.getY();

        Cell next = null;
        if (isValidCell(x + 1, y)) {
            next = maze.getCellAt(x + 1, y);
        } else if (isValidCell(x, y + 1)) {
            next = maze.getCellAt(x, y + 1);
        } else if (isValidCell(x, y - 1)) {
            next = maze.getCellAt(x, y - 1);
        } else if (isValidCell(x - 1, y)) {
            next = maze.getCellAt(x - 1, y);
        }
        return next;
    }

    private boolean isValidCell(int x, int y) {
        Cell cell = maze.getCellAt(x,y);
        return (!cell.isWall() && !visitedCells.contains(cell));
    }

    public int getSolutionPathSize() {
        return pathCells.size();
    }

    private void cleanup() {
        maze.getTargetCell().setCellValue('T');
        Cell[][] mazeCells = maze.getMaze();
        for (int i = 0; i < mazeCells.length; i++) {
            for(int j=0; j < mazeCells[0].length; j++) {
                if(mazeCells[i][j].getCellValue() == 'X' && !pathCells.contains(mazeCells[i][j])) {
                    mazeCells[i][j].setCellValue(' ');
                }
            }
        }
    }
}
