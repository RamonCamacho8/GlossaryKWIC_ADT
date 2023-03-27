package com.glossarykwic_adt.Modules;

import com.glossarykwic_adt.Modules.InputImpl.InputFromPDF;
import com.glossarykwic_adt.Modules.InputImpl.InputStrategy;
import com.glossarykwic_adt.Modules.KWgenImpl.KWgenFromFile;
import com.glossarykwic_adt.Modules.KWgenImpl.KWgenFromPDF;
import com.glossarykwic_adt.Modules.KWgenImpl.KWgenStrategy;



public class InputModule extends IModule  {

    private InputStrategy inputStrategy;
    private KWgenStrategy kwgenStrategy;
    private String documentName = null;
    private String kwFileName = null;


    public InputModule(String fileName) {
        super("Input");
        this.inputStrategy = new InputFromPDF();
        this.documentName = fileName;
    }

    public InputModule(String fileName, String kwFileName) {
        super("Input");
        this.inputStrategy = new InputFromPDF();
        this.documentName = fileName;
        this.kwFileName = kwFileName;
    }

    private void run() {

        if(this.kwFileName != null){
            kwgenStrategy = new KWgenFromFile();
            keywords = kwgenStrategy.read(this.kwFileName);
        }
        else{
            kwgenStrategy = new KWgenFromPDF();
            keywords = kwgenStrategy.read(this.documentName);
        }
        
        text = inputStrategy.read(this.documentName);

    }

    @Override
    public void run(IModule module) {
        run();
    }



 
    
}