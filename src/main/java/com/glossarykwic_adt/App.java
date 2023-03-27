package com.glossarykwic_adt;


import java.io.IOException;

import com.glossarykwic_adt.Modules.InputModule;
import com.glossarykwic_adt.Modules.AlphabetizerModule;
import com.glossarykwic_adt.Modules.IModule;
import com.glossarykwic_adt.Modules.WordsFinderModule;
import com.glossarykwic_adt.Modules.OutputModule;



public class App {
    
    public static void main(String[] args) throws IOException{

        String pdfName = "Document2";
        String kwName = "keywords";

        MasterControl masterControl = new MasterControl();

        masterControl.addModule(new InputModule(pdfName,kwName));
        masterControl.addModule(new AlphabetizerModule());
        masterControl.addModule(new OutputModule());
        masterControl.addModule(new WordsFinderModule());

        //masterControl.addModule(new InputModule(pdfName, kwName));

        masterControl.run();

        

    }
}
