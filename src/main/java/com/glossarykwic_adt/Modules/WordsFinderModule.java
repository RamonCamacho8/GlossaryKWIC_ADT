package com.glossarykwic_adt.Modules;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsFinderModule extends IModule {

    public WordsFinderModule() {
        super("WordsFinderModule");
    }

    //This method returns the pages where the keyword is found
    private Set<Integer> getPages(String keyword, LinkedHashMap<Integer, String> text) {
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

    @Override
    public void run(IModule module) {
        text = module.getText();
        keywords = module.getKeywords();

        for(String keyword : keywords.keySet()) {
            keywords.put(keyword, getPages(keyword, text));
        }
        
    }



  
    
}
