//1. cd ~/jake + ./face = ~/jake/face 4/25
//
//        ~ ~/jake =  ~/jake
//
//
//        ~    root
//        .    current dir
//        ..   parent dir
//
//        ~/jake/handsome ./.. = ~/jake
//        ~/jake ./../.. = ~

package com.leo.jakeclass;

import java.util.Stack;

public class FinalMergeDictionary {
    public static String mergeDictionary(String dict1, String dict2) {
        String dicts = dict1 + '/' + dict2;
        String[] words = dicts.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("~")) {//can't use '' here
                stack = new Stack<>();
                //stack.removeAllElements();
                //stack.clear();
            } else if (!stack.isEmpty() && words[i].equals("..")) {
                stack.pop();
            } else if (stack.isEmpty() && words[i].equals("..")) {
                continue;
            } else if (words[i].equals(".")) {
                continue;
            } else {
                stack.push(words[i]);
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }

        return "~" + sb.toString();
    }

    public static void main(String[] args) {
        String dict1 = "~/jake";
        String dict2 = "./../../..";
        System.out.println(mergeDictionary(dict1, dict2));
    }
}
