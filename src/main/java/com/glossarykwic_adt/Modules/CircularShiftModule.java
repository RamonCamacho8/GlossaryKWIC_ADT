package com.glossarykwic.Modules;

import java.util.ArrayList;

public class CircularShiftModule extends IModule {
   
    
    
    public CircularShiftModule() {
        super("CircularShift");
    }

    public void run(IModule module) {
        lines = module.getData();
        shift();
    }

    private void shift() {
        ArrayList<ArrayList<String>> temp_shiftedLines = new ArrayList<ArrayList<String>>();
        temp_shiftedLines.addAll(lines);

        for (ArrayList<String> line : temp_shiftedLines) {
            shiftLine(line, line.size(), lines);
        }
    }

    private void shiftLine(ArrayList<String> line, int shifts, ArrayList<ArrayList<String>> shiftedLines) {

        if (shifts == 1) {
            return;
        }

        ArrayList<String> temp_line = new ArrayList<String>();
        temp_line.addAll(line);

        temp_line.add(temp_line.get(0));
        temp_line.remove(0);

        shiftedLines.add(new ArrayList<>(temp_line));

        shiftLine(temp_line, shifts - 1, shiftedLines);
    }

}
