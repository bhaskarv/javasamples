package org.learn.threads;

import java.io.IOException;

/**
 * Created by vinay on 21/9/19.
 */
public class FileWriter {
    String propertyName;
    String fileLocation;

    public FileWriter(String propertyName, String fileLocation) {
        this.propertyName = propertyName;
        this.fileLocation = fileLocation;
    }

    public boolean writeFile() throws IOException {
        System.out.println(" Done with writing file for property "+propertyName);
        return true;
    }
}
