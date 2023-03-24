package com.glossarykwic.Modules;

import java.util.ArrayList;

public abstract class IModule {
    protected ArrayList<ArrayList<String>> lines;
    protected String name;
    
    public IModule() {
        lines = new ArrayList<ArrayList<String>>();
        
    }
    public IModule(String name) {
        lines = new ArrayList<ArrayList<String>>();
        this.name = name;
    }

    public abstract void run(IModule module);
    

    public ArrayList<ArrayList<String>> getData(){
        return lines;
    }

    public String getName() {
        return name;
    }
}
