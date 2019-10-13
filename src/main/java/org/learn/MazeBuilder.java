package org.learn;

/**
 * Created by vinay on 25/2/18.
 */
public class MazeBuilder {

    public Maze buildMazeFromData(int[][] mazeData, int startRow, int startCol, int destRow, int destCol) {
        Cell sourceCell = new Cell(startCol, startRow);
        Cell targetCell = new Cell(destCol, destRow);

        Maze maze = new Maze();
        maze.setSourceCell(sourceCell);
        maze.setTargetCell(targetCell);

        int totalRows = mazeData.length;
        int totalCols = mazeData[0].length;

        Cell[][] mazeCells = new Cell[totalRows][totalCols];

        for (int i = 0 ; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                Cell cell = new Cell(i,j);
                cell.setWall(true);
                cell.setCellValue('#');
                if (mazeData[i][j] == 0) {
                    cell.setWall(false);
                    cell.setCellValue(' ');
                }
                mazeCells[i][j] = cell;
            }
        }
        setStartCell(mazeCells, sourceCell);
        setTargetCell(mazeCells, targetCell);
        maze.setMaze(mazeCells);

        return maze;
    }

    private void setStartCell(Cell[][] maze, Cell cell) {
        maze[cell.getX()][cell.getY()] = cell;
        maze[cell.getX()][cell.getY()].setCellValue('S');
    }

    private void setTargetCell(Cell[][] maze, Cell cell) {
        maze[cell.getX()][cell.getY()] = cell;
        maze[cell.getX()][cell.getY()].setCellValue('T');
    }

}
