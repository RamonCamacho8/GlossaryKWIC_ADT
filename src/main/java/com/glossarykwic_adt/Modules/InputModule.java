package com.glossarykwic_adt.Modules;

public class InputModule extends IModule{

    private InputStrategy inputStrategy;

    public InputModule( ) {
        super("Input");
        this.inputStrategy = new FromTxtFile();
    }

    @Override
    public void run(IModule module) {
        readInput();
    }

    private void readInput() {
        lines = inputStrategy.read();
    }
    
}
