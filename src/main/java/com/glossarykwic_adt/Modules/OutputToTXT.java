package com.glossarykwic_adt.Modules;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class OutputToTXT implements OutputStrategy{

    private int lineLength = 40;
    @Override
    public void write(String filename, HashMap<String,Set<Integer>> gloassary ) {
        
        String fileDirectory = "src/main/java/com/glossarykwic_adt/persistence/"+filename+"_glossary.txt";

        
        try {
            FileWriter myWriter = new FileWriter(fileDirectory);
            myWriter.write("Palabra:" + " ".repeat(lineLength - "Palabra".length()) + "Paginas:" + "\r");
            for(String key : gloassary.keySet()){
                myWriter.write(lineFormater(key,gloassary.get(key)));
            }
            
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private String lineFormater(String key, Set<Integer> set) {
        String line = key ;
        int wordLength = line.length();

        for (int i = 0; i < lineLength - wordLength; i++) {
            line += ".";
        }
        line += " ";
        if (!set.isEmpty()) {
            for (Integer integer : set) {
                line += integer + ",";
            }
            line = line.substring(0, line.length()-1);
        }
        else {
            line += "No aparece.";
        }
        
        return line+"\r";
    } 
    
}
