package com.glossarykwic_adt.Modules;


import java.util.LinkedHashMap;
import java.util.Set;

import com.glossarykwic_adt.Modules.OutputImpl.OutputStrategy;
import com.glossarykwic_adt.Modules.OutputImpl.OutputToTXT;


public class OutputModule extends IModule{
    private OutputStrategy outputStrategy;
    private String outputFileName;

    public OutputModule() {
        super("Output");
        this.outputStrategy = new OutputToTXT();
        this.outputFileName = "output";
    }
    public OutputModule(String outputFileName) {
        super("Output");
        this.outputStrategy = new OutputToTXT();
        this.outputFileName = outputFileName;
    }

    private void write(String filename, LinkedHashMap<String,Set<Integer>> keywords) {
        outputStrategy.write(filename, keywords);
    }

    @Override
    public void run(IModule module) {
        write(outputFileName, module.getKeywords());
    }


}
