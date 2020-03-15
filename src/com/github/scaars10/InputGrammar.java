package com.github.scaars10;

import java.util.*;


public class InputGrammar {
    HashMap<Character, ArrayList<String>> grammar = new HashMap<Character, ArrayList<String>>();

    void addProduction(String production){

        Character nT = production.split("-")[0].charAt(0);
        String prod = production.split("-")[1];
        String[] productions = prod.split("!");
        grammar.computeIfAbsent(nT, k -> new ArrayList<>())
                .addAll(Arrays.asList(productions));

    }

    void viewGrammar(){
        System.out.println("Size of grammar is "+grammar.size());

        for (Map.Entry<Character, ArrayList<String>> entry : grammar.entrySet()) {
            ArrayList<String> vec = entry.getValue();
            Character k = entry.getKey();

            for (String s : vec){
                System.out.println(k+" -> "+s);
            }
        };
    }
    boolean isNonTerminal(Character c){
        return c >= 'A' && c <= 'Z';
    }
    String findValidProduction(Character token, Character nT){
        ArrayList<String> vec = grammar.get(nT);
        for(int i=0;i<vec.size();i++){
            String prod = vec.get(i);
            if(prod.charAt(0)==token)
                return prod;
        }
        return null;
    }
}
