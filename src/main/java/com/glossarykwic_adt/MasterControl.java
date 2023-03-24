package com.glossarykwic_adt;

import com.glossarykwic_adt.Modules.IModule;
import com.glossarykwic_adt.Modules.InputModule;
import com.glossarykwic_adt.Modules.OutputModule;

import java.util.ArrayList;

import com.glossarykwic_adt.Modules.AlphabetizerModule;
import com.glossarykwic_adt.Modules.CircularShiftModule;

public class MasterControl {

    private ArrayList<IModule> modules;
    
    public MasterControl( ) {
        modules = new ArrayList<IModule>();
        modules.add( new InputModule());
        modules.add( new CircularShiftModule());
        modules.add( new AlphabetizerModule());
        modules.add( new OutputModule());
    }


    public IModule getModuleByName(String name) {

        for (IModule module : modules) {
            if (module.getName().equals(name)) {
                return module;
            }
        }
        return null;
    }

}