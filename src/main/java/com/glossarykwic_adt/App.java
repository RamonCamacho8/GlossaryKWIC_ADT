package com.glossarykwic_adt;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class App {
    
    public static void main(String[] args) throws IOException{
        //MasterControl mc = new MasterControl();

        /*mc.getModuleByName("Input").run(null);
        mc.getModuleByName("CircularShift").run(mc.getModuleByName("Input"));
        mc.getModuleByName("Alphabetizer").run(mc.getModuleByName("CircularShift"));
        mc.getModuleByName("Output").run(mc.getModuleByName("Alphabetizer"));*/
        //Loading an existing document
        HashMap<Integer, String> pageTextMap;
        try {
            // Load the PDF document
            PDDocument document = PDDocument.load(new File("src/main/java/com/glossarykwic_adt/persistence/Document.pdf"));

            // Create a HashMap to store the page number and its corresponding text
            pageTextMap = new HashMap<Integer, String>();

            // Create a PDFTextStripper object to extract the text from the pages
            PDFTextStripper textStripper = new PDFTextStripper();

            // Loop through each page in the document
            for (int i = 1; i <= document.getNumberOfPages(); i++) {
                // Set the current page number for the text stripper
                textStripper.setStartPage(i);
                textStripper.setEndPage(i);

                // Extract the text from the current page
                String pageText = textStripper.getText(document);

                // Add the page number and text to the HashMap
                pageTextMap.put(i, pageText);
            }

            // Print the HashMap
            System.out.println(pageTextMap);

            // Close the PDF document
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
