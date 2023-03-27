package com.glossarykwic_adt.Modules.KWgenImpl;


import java.util.LinkedHashMap;
import java.util.Set;

public interface KWgenStrategy{
    public LinkedHashMap<String,Set<Integer>> read(String filename);
}
