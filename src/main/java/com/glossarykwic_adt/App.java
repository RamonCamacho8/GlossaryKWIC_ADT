package com.glossarykwic;

import java.io.File;
import java.io.IOException;
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
   
         //Loading an existing document
        File file = new File("glossarykwic/src/main/java/com/glossarykwic/persistence/Document.pdf");
        PDDocument document = PDDocument.load(file);
        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();
        //Retrieving text from PDF document
        String text = pdfStripper.getText(document);
        System.out.println(text);   
        //Closing the document
        document.close();
        
    }
}
