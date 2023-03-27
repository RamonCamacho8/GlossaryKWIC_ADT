package com.glossarykwic_adt.Modules;

import java.util.LinkedHashMap;
import java.util.Set;

public abstract class IModule {

    //The key is for the page number and the value is for the text in that page
    protected LinkedHashMap<Integer,String> text;
    protected LinkedHashMap<String,Set<Integer>> keywords;
    protected String name;
    

    public IModule(String name) {
        this.name = name;
    }

    public abstract void run(IModule module);


    public String getName() {
        return name;
    }

    public LinkedHashMap<Integer, String> getText() {
        return text;
    }
    public LinkedHashMap<String,Set<Integer>> getKeywords() {
        return keywords;
    }
}
