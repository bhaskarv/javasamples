package org.learn;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by vinay on 24/2/18.
 */
public class MazeDataReaderTest {

    private MazeDataReader fileReader;

    @Before
    public void setup() {
        fileReader = new MazeDataReader();
    }

    @Test
    public void testReadFile() throws Exception {
        Maze maze = fileReader.readDataFromFile("/home/vinay/IdeaProjects/samples/src/test/java/org/learn/small.txt");
        Cell[][] mazeCells = maze.getMaze();
        for (int i = 0; i < mazeCells.length; i++) {
            for(int j=0; j < mazeCells[0].length; j++) {
                System.out.print(mazeCells[i][j].getCellValue()+"");
            }
            System.out.print("\n");
        }
    }

}
