package com.glossarykwic_adt.Modules;

public class OutputModule extends IModule {

    private OutputStrategy outputStrategy;

    public OutputModule() {
        super("Output");
        this.outputStrategy = new ToTxtFile();
    }

    @Override
    public void run(IModule module) {
        outputStrategy.write(module.getData());
    }
    
}
