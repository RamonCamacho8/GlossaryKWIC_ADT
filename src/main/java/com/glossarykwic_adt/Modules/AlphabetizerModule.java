package com.glossarykwic_adt.Modules;

import java.util.ArrayList;

public class AlphabetizerModule extends IModule {
    
    public AlphabetizerModule() {
        super("Alphabetizer");
    }

    @Override
    public void run(IModule module) {
        alphabetize(module);
        
    }

    private void alphabetize(IModule module) {
        ArrayList<ArrayList<String>> shiftedLines = module.getData();
        ArrayList<String> shiftedLinesString = new ArrayList<String>();

        for (ArrayList<String> line : shiftedLines) {
            shiftedLinesString.add(String.join(" ", line));
        }

        shiftedLinesString.sort(String.CASE_INSENSITIVE_ORDER);

        for (String line : shiftedLinesString) {
            ArrayList<String> tempLine = new ArrayList<String>();
            String[] words = line.split(" ");
            for (String word : words) {
                tempLine.add(word);
            }
            lines.add(tempLine);
        }
    }

}
