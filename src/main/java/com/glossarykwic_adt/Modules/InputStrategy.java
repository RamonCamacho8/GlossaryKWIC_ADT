package com.glossarykwic_adt.Modules;

import java.util.ArrayList;

public interface InputStrategy {
    public ArrayList<ArrayList<String>> read();
    public ArrayList<ArrayList<String>> read(String filename, String wordsFileName);
}
