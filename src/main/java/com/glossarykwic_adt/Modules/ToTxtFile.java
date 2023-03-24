package com.glossarykwic.Modules;

import java.io.FileWriter;
import java.util.ArrayList;

public class ToTxtFile implements OutputStrategy{

    @Override
    public void write(ArrayList<ArrayList<String>> data) {
        ArrayList<ArrayList<String>> alphabetizedShiftedLines = data;
        String fileName = "case_1";
        String fileDirectory = "src/persistence/"+"Output_"+fileName+".txt";
        
        try {
            FileWriter writer = new FileWriter(fileDirectory);
            for (ArrayList<String> line : alphabetizedShiftedLines) {
                int i = alphabetizedShiftedLines.indexOf(line);
                writer.write(i + ". ");
                for(String word : line){
                    writer.write(word + " ");
                }
                writer.write("\n");
            }


            writer.close();
            System.out.println("Archivo escrito con éxito.");
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al escribir el archivo.");
            e.printStackTrace();
        }
    }
    
}
