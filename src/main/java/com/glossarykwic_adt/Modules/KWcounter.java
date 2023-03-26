package com.glossarykwic_adt.Modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KWcounter extends IModule {

    public KWcounter(String name) {
        super(name);
    }

    @Override
    public HashMap<String,Set<Integer>> run(HashMap<Integer, String> text, ArrayList<String> keywords) {
        
        
        HashMap<String,Set<Integer>> kwLines = new HashMap<String,Set<Integer>>();


        for (String keyword : keywords) {
            kwLines.put(keyword, getPages(keyword, text));
        }

        for (String keyword : kwLines.keySet()) {
            System.out.println(keyword + " : " + kwLines.get(keyword));
        }

        return kwLines;

    }

    private Set<Integer> getPages(String keyword, HashMap<Integer, String> text) {
        Set<Integer> pages = new HashSet<Integer>();

        Pattern pattern = Pattern.compile( keyword + "[\\p{Punct}]?"); // add pattern to match the keyword with or without punctuation
        
        for(Integer page : text.keySet()) {
            Matcher matcher = pattern.matcher(text.get(page));
            while (matcher.find()) {
                pages.add(page);
                
            }
        } 

        return pages;

    }

  
    
}
