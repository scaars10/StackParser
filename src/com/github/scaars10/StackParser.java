package com.github.scaars10;

import java.util.Stack;

public class StackParser {
    public InputGrammar grammar = new InputGrammar();
    Character startState = 'S';
    public boolean checkMember(String str){
        Stack<Character> stack= new Stack<Character>();
        int ptr = 0; //points to the position of the present token in the input string
        Character endOfStack = '$';
        stack.push(endOfStack);
        stack.push(startState);
        while(ptr<str.length()){
            Character token = str.charAt(ptr);
            Character nT = stack.peek();
            if(grammar.isNonTerminal(nT)){
                if(nT==token){
                    ptr++;
                    stack.pop();
                    continue;
                }
                return false; //String cannot be generated
            }
            String grammar.findValidProduction(token, nT);
        }
    }
}
