package com.glossarykwic_adt;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.glossarykwic_adt.Modules.Input;
import com.glossarykwic_adt.Modules.KWcounter;
import com.glossarykwic_adt.Modules.KWfromFile;
import com.glossarykwic_adt.Modules.KWgenerator;
import com.glossarykwic_adt.Modules.Output;


public class App {
    
    public static void main(String[] args) throws IOException{

        Input input = new Input();
        KWgenerator kw_Generator = new KWfromFile();
        KWcounter kw_Counter = new KWcounter("KeywordCounter");
        Output output = new Output();

        String pdfName = "Document2";
        HashMap<Integer,String> text = input.read(pdfName);
        ArrayList<String> keywords = kw_Generator.read("case_1");

        HashMap<String,Set<Integer>> glossary = kw_Counter.run(text, keywords);
        output.write(pdfName,glossary);


    }
}
