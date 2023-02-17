package org.example.infrastructure;

import java.io.*;
import java.util.ArrayList;

public class FileParser {
    private final ClassLoader classLoader;

    public FileParser() {
        classLoader = getClass().getClassLoader();
    }


    public ArrayList<String> parseFile(String fileName) {
        String filepath = classLoader.getResource(fileName).getPath();

        File file = new File(filepath);

        if(!file.exists()) {
            throw new IllegalArgumentException("File " + fileName + " does not exist");
        }

        ArrayList<String> lines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while((line = reader.readLine()) != null) {
                lines.add(line);
            }

            reader.close();
        } catch (IOException exception) {
            throw new RuntimeException("Error while reading file " + fileName, exception);
        }


        return lines;
    }


}
