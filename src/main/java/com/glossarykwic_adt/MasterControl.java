package com.glossarykwic;

import com.glossarykwic.Modules.IModule;
import com.glossarykwic.Modules.InputModule;
import com.glossarykwic.Modules.OutputModule;

import java.util.ArrayList;

import com.glossarykwic.Modules.AlphabetizerModule;
import com.glossarykwic.Modules.CircularShiftModule;

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