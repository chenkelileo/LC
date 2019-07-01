package com.leo.cct189;

import java.util.Arrays;

public class IsUnique_1_1 {
    //not easy to return position/ index
    public static boolean isUnique(String str) {
        if(str == null || str.length() == 0)
            return false;

        char[] cs = str.toCharArray();
        Arrays.sort(cs);

//        for (char c : cs) {
//            System.out.println(c);
//        }

        for(int i = 1; i < cs.length; i++){
            if(cs[i] == cs[i-1])
                return false;
        }
        return true;
    }
    //t:o(n)
    //s:o(1)

    public static void main(String[] args) {
        System.out.println(isUnique("acd"));
    }
}
