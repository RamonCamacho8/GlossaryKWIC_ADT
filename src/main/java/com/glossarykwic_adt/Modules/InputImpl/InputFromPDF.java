package com.glossarykwic_adt.Modules.InputImpl;

import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.LinkedHashMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class InputFromPDF implements InputStrategy  {

    @Override
    public LinkedHashMap<Integer,String> read(String filename) {
        LinkedHashMap<Integer, String> mappedText = new LinkedHashMap<Integer, String>();

        try {
            // Load the PDF document
            PDDocument document = PDDocument.load(new File("src/main/java/com/glossarykwic_adt/persistence/"+filename+".pdf"));

            // Create a HashMap to store the page number and its corresponding text

            // Create a PDFTextStripper object to extract the text from the pages
            PDFTextStripper textStripper = new PDFTextStripper();

            // Loop through each page in the document
            for (int i = 1; i <= document.getNumberOfPages(); i++) {
                // Set the current page number for the text stripper
                textStripper.setStartPage(i);
                textStripper.setEndPage(i);

                // Extract the text from the current page
                String pageText = textStripper.getText(document);
                pageText = pageText.toLowerCase();
                
                pageText = Normalizer.normalize(pageText, Normalizer.Form.NFKD);
                pageText = pageText.replaceAll("[^\\p{ASCII}]", "").replaceAll("[\\p{Punct}]?", "");
                // Add the page number and text to the HashMap
                mappedText.put(i, pageText);
            }

            // Close the PDF document
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mappedText;
    }
    
}
