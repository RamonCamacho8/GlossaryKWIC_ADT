package com.glossarykwic_adt.Modules;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class KWfromPDF implements KWgenerator {

    @Override
    public ArrayList<String> read(String filename) {

        ArrayList<String> keywords = new ArrayList<String>();
        String fileDirectory = "src/main/java/com/glossarykwic_adt/persistence/"+filename+".pdf";

        try {
            // Load the PDF document
            PDDocument document = PDDocument.load(new File(fileDirectory));

            PDFTextStripper textStripper = new PDFTextStripper();

            String text = textStripper.getText(document);



            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return keywords;
    }

    private void textCleaner(String text) {
        
        String[] textArray = text.split(" ");

        for (int i = 0; i < textArray.length; i++) {
            textArray[i] = textArray[i].replaceAll("[^a-zA-Z0-9]", "");
        }

    }

}
