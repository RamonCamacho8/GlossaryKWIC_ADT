package com.glossarykwic_adt.Modules;

import java.util.HashMap;
import java.util.Set;

public interface OutputStrategy {
    public void write(String filename,HashMap<String,Set<Integer>> gloassary);
}
