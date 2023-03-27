package com.glossarykwic_adt.Modules.KWgenImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class KWgenFromFile implements KWgenStrategy {

    

    @Override
    public LinkedHashMap<String,Set<Integer>> read(String filename) {
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

        LinkedHashMap<String,Set<Integer>> mappedkW = new LinkedHashMap<String,Set<Integer>>();

        for (int i = 0; i < keywords.size(); i++) {
            mappedkW.put(keywords.get(i), null);
        }

        return mappedkW;

    }
    
}
