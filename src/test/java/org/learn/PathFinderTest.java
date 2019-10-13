package org.learn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vinay on 25/2/18.
 */
public class PathFinderTest {

    private PathFinder pathFinder;
    private Maze maze;
    private MazeDataReader dataReader;

    @Before
    public void setup() throws Exception {
        dataReader = new MazeDataReader();
        String input = "/home/vinay/IdeaProjects/samples/src/test/java/org/learn/input.txt";
        maze = dataReader.readDataFromFile(input);
        pathFinder = new PathFinder(maze);
    }

    @Test
    public void testSolveMaze() {

        Cell[][] mazeCells = maze.getMaze();

        /*System.out.println(" INPUT MAZE ");
        for (int i = 0; i < mazeCells.length; i++) {
            for(int j=0; j < mazeCells[0].length; j++) {
                System.out.print(mazeCells[i][j].getCellValue()+"");
            }
            System.out.println("");
        }*/

        boolean solutionExists = pathFinder.solveMaze();
        if (pathFinder.solveMaze() == true) {
            //System.out.println(" SOLUTION EXISTS ");

            for (int i = 0; i < mazeCells.length; i++) {
                for(int j=0; j < mazeCells[0].length; j++) {
                    System.out.print(mazeCells[i][j].getCellValue()+"");

                }
                System.out.println("");
            }
        }
        else
            System.out.println(" NO SOLUTION ");

    }
}
