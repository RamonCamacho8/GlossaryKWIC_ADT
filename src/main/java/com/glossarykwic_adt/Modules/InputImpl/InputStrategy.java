package com.glossarykwic_adt.Modules.InputImpl;


import java.util.LinkedHashMap;

public interface InputStrategy {
    public LinkedHashMap<Integer,String> read(String filename);
  
}
