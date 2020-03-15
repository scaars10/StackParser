package com.github.scaars10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class InputGrammar {
    HashMap<Character, ArrayList<String>> grammar = new HashMap<Character, ArrayList<String>>();

    void addProduction(String production){

        Character nT = production.split("-")[0].charAt(0);
        String prod = production.split(" ")[1];
        String[] productions = prod.split("|");
        grammar.computeIfAbsent(nT, k -> new ArrayList<>())
                .addAll(Arrays.asList(productions));

    }

    boolean isNonTerminal(Character c){
        if(c>='A' && c<='Z')
            return true;
        return false;
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
