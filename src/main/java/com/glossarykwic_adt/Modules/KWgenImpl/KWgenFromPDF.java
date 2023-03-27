package com.glossarykwic_adt.Modules.KWgenImpl;

import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.LinkedHashMap;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class KWgenFromPDF implements KWgenStrategy {

    @Override
    public LinkedHashMap<String,Set<Integer>> read(String filename) {

        
        String fileDirectory = "src/main/java/com/glossarykwic_adt/persistence/"+filename+".pdf";
        String text = "";
        try {
            // Load the PDF document
            PDDocument document = PDDocument.load(new File(fileDirectory));

            PDFTextStripper textStripper = new PDFTextStripper();

            text = textStripper.getText(document);

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        return keywordsMaker(textCleaner(text));
    }

    

    private String[] articulos = {"unos", "uno", "el", "la", "los", "las", "un", "una", "unos", "unas", "el", "lo","no","si","sera","esos","otro","debe"
    ,"ese","sus"};

    private String[] preposiciones = {"a", "ante", "bajo", "cabe", "con", "contra", "de", "desde", "durante", "en",
     "entre", "hacia", "hasta", "mediante", "para", "por", "según", "sin", "so", "sobre", "tras", "versus", "vía","son","aquellas","del"};

    private String[] conjunciones = {"y", " o ", "u", "e", "ni", "pero", "sino", "como", "que", "si", "aunque", "porque","mas",
    "empero","mientras que","o bien","bien","ya","ora","sea","fuera","más","que","es","tales","estos","estas","esta","esto","este","sido","se","junto","se","han"};


    private String textCleaner(String text) {

        String cleanedText = text.toLowerCase();
        cleanedText = Normalizer.normalize(cleanedText, Normalizer.Form.NFKD);
  
        
        cleanedText = cleanedText .replace("\n", "")
                    .replaceAll("\\d","")
                    .replaceAll("[^\\p{ASCII}]", "")
                    .replaceAll("[\\p{Punct}]?", "")
                    .replace("\r", "")
                    .replace("  ", " ")
                    .replace("   ", " ");


        for(String articulo : articulos){
            cleanedText = cleanedText.replaceAll(" "+articulo+" ", " ");
        }

        for(String preposicion : preposiciones){
            cleanedText = cleanedText.replaceAll(" "+preposicion+" ", " ");
        }

        for(String conjuncion : conjunciones){
            cleanedText = cleanedText.replaceAll(" "+conjuncion+" ", " ");
        }
        
        return cleanedText;
    }

    private  LinkedHashMap<String,Set<Integer>> keywordsMaker(String text){

        LinkedHashMap<String,Set<Integer>> keywords = new LinkedHashMap<String,Set<Integer>>();

        String[] words = text.split(" ");

        for(String word : words){
            if(word.length() > 3){
                keywords.put(word, null);
            }
        }

        return keywords;
    }

}
