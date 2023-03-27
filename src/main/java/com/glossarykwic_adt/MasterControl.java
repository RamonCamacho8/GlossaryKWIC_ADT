package com.glossarykwic_adt;

import java.util.ArrayList;
import java.util.List;

import com.glossarykwic_adt.Modules.IModule;

public class MasterControl {

    private List<IModule> modules = new ArrayList<IModule>();

    public MasterControl( ) {
        
    }

    public void addModule(IModule module) {
        
        if(module.getName().equals("Input") && getModuleByName("Input") != null) {
            modules.remove(getModuleByName("Input"));
            modules.add(0, module);
            System.out.println("Input module already exists, replacing it with new one");
        }
        else if(module.getName().equals("Output") && getModuleByName("Output") != null) {
            modules.remove(getModuleByName("Output"));
            modules.add(module);
            System.out.println("Output module already exists, replacing it with new one");
        }
        else{
            modules.add(module);
        }


    }

    public void run() {

        orderModules();

        modules.get(0).run(null);

        for(int i = 1; i < modules.size(); i++) {
            modules.get(i).run(modules.get(i-1));
        }

    }

    private void orderModules(){
        List<IModule> orderedModules = new ArrayList<IModule>();
        IModule inputModule = getModuleByName("Input");
        IModule outputModule = getModuleByName("Output");
        
        modules.remove(inputModule);
        modules.remove(outputModule);

        orderedModules.add(inputModule);
        orderedModules.addAll(modules);
        orderedModules.add(outputModule);
        
        modules = orderedModules;
    }

    private IModule getModuleByName(String name){
        for(IModule module : modules){
            if(module.getName().equals(name)){
                return module;
            }
        }
        return null;
    }


}