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

        keywordsPagesFinder();
        
    }

    private void keywordsPagesFinder(){

        for(String keyword : keywords.keySet()) {
            if(keyword.contains(" AND "))
                keywords.put(keyword, getPagesWithAND(keyword, text));
            else
                keywords.put(keyword, getPages(keyword, text));

        }

    }

    private Set<Integer> getPagesWithAND(String keyword, LinkedHashMap<Integer, String> text){
        Set<Integer> pages = new HashSet<Integer>();
        LinkedHashMap<Integer, String> tempText = new LinkedHashMap<Integer, String>(text);
        String[] keywords = keyword.split(" AND ");

         // add pattern to match the keyword with or without punctuation
        
        //For every keyword in the AND statement we split the value String of the text by . and then we check if the keyword is in each sentence
       
        for(Integer page : tempText.keySet()) {
            String[] sentences = tempText.get(page).split("\\.");
            for(String sentence : sentences){
                if(sentence.contains(keywords[0]) && sentence.contains(keywords[1])){
                    pages.add(page);
                    //We remove the sentence from the text so we don't count it again
                    tempText.put(page, tempText.get(page).replace(sentence, ""));
                }
            }
        }
        return pages;
    }



  
    
}
