package com.glossarykwic_adt.Modules;

import java.util.HashMap;
import java.util.Set;

public class Output {
    OutputStrategy outputStrategy;

    public Output( ) {
        this.outputStrategy = new OutputToTXT();
    }

    public void write(String filename, HashMap<String,Set<Integer>> glossary) {
        outputStrategy.write(filename, glossary);
    }


}
