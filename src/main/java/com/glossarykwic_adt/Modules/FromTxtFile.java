package com.glossarykwic.Modules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FromTxtFile implements InputStrategy {

    

    @Override
    public ArrayList<ArrayList<String>> read() {
        String fileName = "case_1"; // replace with the name of your file
        String fileDirectory = "src/persistence/"+fileName+".txt"; // replace with the name of your file
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        ArrayList<String> words;
        try (BufferedReader br = new BufferedReader(new FileReader(fileDirectory))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                words = new ArrayList<>(Arrays.asList(line.split(" ")));
                data.add(words);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return data;
    }
    
}
