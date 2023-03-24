package com.glossarykwic_adt.Modules;

public class Input  {

    private InputStrategy inputStrategy;

    public void read(String filename) {
        inputStrategy.read();
    }

    public void read(String filename, String wordsFileName){
        inputStrategy.read(filename, wordsFileName);
    }
    
}
