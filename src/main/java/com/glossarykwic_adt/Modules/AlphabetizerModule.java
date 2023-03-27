package com.glossarykwic_adt.Modules;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class AlphabetizerModule extends IModule{

    public AlphabetizerModule( ) {
        super("KWAlphabetizer");

    }

    @Override
    public void run(IModule module) {
        text = module.getText();
        alphabetize(module.getKeywords());
    }

    private void alphabetize(LinkedHashMap<String,Set<Integer>> keywords) {
        
        ArrayList<String> tempSortedKeywords = new ArrayList<String>();

        for(String keyword : keywords.keySet()){
            tempSortedKeywords.add(keyword);
        }

        tempSortedKeywords.sort(String.CASE_INSENSITIVE_ORDER);

        LinkedHashMap<String,Set<Integer>> sortedKeywords = new LinkedHashMap<String,Set<Integer>>();

        for(String keyword : tempSortedKeywords){
            sortedKeywords.put(keyword, keywords.get(keyword));
        }

        this.keywords = sortedKeywords;


    }
    
}
