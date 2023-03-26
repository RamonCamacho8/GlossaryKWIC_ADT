package com.glossarykwic_adt.Modules;

import java.util.HashMap;

public class Input  {

    private InputStrategy inputStrategy;

    public Input() {
        this.inputStrategy = new InputFromPDF();
    }

    public HashMap<Integer,String> read(String filename) {
        return inputStrategy.read(filename);
    }
    
}