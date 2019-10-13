package org.learn;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by vinay on 24/2/18.
 */
public class MazeDataReader {

    public Maze readDataFromFile(String inputFileName) throws Exception {
        FileReader fr = new FileReader(inputFileName);
        BufferedReader br = new BufferedReader(fr);

        int rows, cols;
        String line = br.readLine();
        String[] size = line.split(" ");
        cols = Integer.valueOf(size[0]);
        rows = Integer.valueOf(size[1]);

        int[][] maze = new int[rows][cols];

        String[] startPoint = br.readLine().split(" ");

        String[] destPoint = br.readLine().split(" ");

        int currRow = 0;
        while ((line = br.readLine()) != null) {
            maze[currRow] = convertLine(line);
            currRow++;
        }
        Maze newMaze = new MazeBuilder().buildMazeFromData(maze, Integer.valueOf(startPoint[0]),
                                        Integer.valueOf(startPoint[1]),
                                        Integer.valueOf(destPoint[0]),
                                        Integer.valueOf(destPoint[1]));
        return newMaze;
    }

    private int[] convertLine(String input) {
        String[] line = input.split(" ");
        int[] row = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            row[i] = Integer.valueOf(line[i]);
        }
        return row;
    }
}


