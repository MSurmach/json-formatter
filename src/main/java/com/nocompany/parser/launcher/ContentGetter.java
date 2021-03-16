package com.nocompany.parser.launcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ContentGetter {

    private BufferedReader fileReader;
    private File parsebleFile;

    /**
     * Creates the instance of ContentGetter class, and initializes the
     * parsebleFile {@link ContentGetter#parsebleFile} field.
     *
     * @param pathToFile string representation of path to the file.
     */
    ContentGetter(String pathToFile) {
        parsebleFile = new File(pathToFile);
    }

    /**
     * Reads line by line content from file.
     *
     * @return the string representation of file
     */
    String getJSONAsString() {
        connectToFile();
        StringBuilder buffer = new StringBuilder();
        try {
            while (fileReader.ready()) {
                buffer.append(fileReader.readLine()).append("\n");
            }
        } catch (IOException exception) {
            System.out.println("The programm can not read a content of file");
        } finally {
            closeConnectionToFile();
        }
        return buffer.toString();
    }

    /**
     * Creates the inputStream {@link FileReader} to the file.
     */
    private void connectToFile() {
        try {
            fileReader = new BufferedReader(new FileReader(parsebleFile));
        } catch (FileNotFoundException ex) {
        }
    }

    /**
     * Closes the inputStream {@link FileReader}
     */
    private void closeConnectionToFile() {
        try {
            fileReader.close();
        } catch (IOException exception) {
            System.out.println("Stream to file can not be closed");
        }
    }
}
