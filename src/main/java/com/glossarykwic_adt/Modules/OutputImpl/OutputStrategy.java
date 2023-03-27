package com.glossarykwic_adt.Modules.OutputImpl;

import java.util.LinkedHashMap;
import java.util.Set;

public interface OutputStrategy {
    public void write(String filename,LinkedHashMap<String,Set<Integer>> keywords);
}
