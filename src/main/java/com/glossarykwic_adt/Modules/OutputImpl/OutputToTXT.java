package com.glossarykwic_adt.Modules.OutputImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class OutputToTXT implements OutputStrategy{

    private int lineLength = 40;
    @Override
    public void write(String filename, LinkedHashMap<String,Set<Integer>> glossary ) {
        
        String fileDirectory = "src/main/java/com/glossarykwic_adt/persistence/"+filename+"_glossary.txt";

        
        try {
            FileWriter myWriter = new FileWriter(fileDirectory);
            myWriter.write("Palabra:" + " ".repeat(lineLength - "Palabra".length()) + "Paginas:" + "\r");
            //Iterates over the words in the glossary and writes them to the file with the pages they appear in
            for(String key : glossary.keySet()){
                myWriter.write(lineFormater(key,glossary.get(key)));
            }
            
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private String lineFormater(String keyword, Set<Integer> pages) {
        String line = keyword;
        String capitalLetter = line.substring(0, 1).toUpperCase();
        line = capitalLetter + line.substring(1);
        int wordLength = line.length();


        List<Integer> sortedPages = new ArrayList<Integer>();
        
        if(pages != null){
            sortedPages.addAll(pages);
            Collections.sort(sortedPages);
        }
        

        for (int i = 0; i < lineLength - wordLength; i++) {
            line += ".";
        }
        line += " ";


        if(sortedPages != null){
            if (!sortedPages.isEmpty()) {
                for (Integer integer : sortedPages) {
                    line += integer + ",";
                }
                line = line.substring(0, line.length()-1);
            }
            else {
                return "";
            }
        }
        
        return line+"\r";
    }


    
}
