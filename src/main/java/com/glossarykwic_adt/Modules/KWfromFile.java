package com.glossarykwic_adt.Modules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KWfromFile implements KWgenerator {

    @Override
    public ArrayList<String> read(String filename) {
        ArrayList<String> keywords = new ArrayList<String>();
        String fileDirectory = "src/main/java/com/glossarykwic_adt/persistence/"+filename+".txt";

        //Read a txt file and return a HashMap where keys are integers and values are strings}

        try (BufferedReader reader = new BufferedReader(new FileReader(fileDirectory))) {
            String line;
            while ((line = reader.readLine()) != null) {
                keywords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return keywords;

    }
    
}
