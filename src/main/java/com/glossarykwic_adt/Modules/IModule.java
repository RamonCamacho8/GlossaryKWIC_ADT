package com.glossarykwic_adt.Modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public abstract class IModule {

    
    protected String name;
    

    public IModule(String name) {
        this.name = name;
    }

    public abstract HashMap<String,Set<Integer>> run(HashMap<Integer,String> text, ArrayList<String> keywords);

    public String getName() {
        return name;
    }
}
