package com.github.scaars10;

import java.util.Scanner;

public class RunParser {



    public static void main(String [] args){
        StackParser parser = new StackParser();
        System.out.println("Parser only checks LL(1) Grammars.\nResult will be unexpected otherwise" +
                "\n-----------------\n");
        System.out.println("Add Productions in the format:- S-abc|b|cd. Enter -1 when done");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = sc.nextLine();
            if (str.equals("-1"))
                break;
            parser.grammar.addProduction(str);
        }
        System.out.println("Enter the strings you want to check. Enter -1 when done");
        while(true){
            String str = sc.nextLine();
            if(str.equals("-1"));
            parser.checkMember(str);
        }
    }

}
