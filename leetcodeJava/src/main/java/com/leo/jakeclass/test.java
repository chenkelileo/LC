package com.leo.jakeclass;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashMap;

class test {
    public static String solution(String S, int K) {
        // write your code in Java SE 8
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Mon");
        map.put(2, "Tue");
        map.put(3, "Wed");
        map.put(4, "Thu");
        map.put(5, "Fri");
        map.put(6, "Sat");
        map.put(7, "Sun");

        for (int a : map.keySet()) {
            if (map.get(a).equals(S)) {
                K = K + a;
                break;
            }
        }


//        if (S.equals("Mon")) {
//            K = K + 1;
//        } else if (S.equals("Tue")) {
//            K = K + 2;
//        } else if (S.equals("Wed")) {
//            K = K + 3;
//        } else if (S.equals("Thu")) {
//            K = K + 4;
//        } else if (S.equals("Fri")) {
//            K = K + 5;
//        } else if (S.equals("Sat")) {
//            K = K + 6;
//        } else if (S.equals("Sun")) {
//            K = K + 5;
//        }
        while (K > 7) {
            K = K - 7;
        }
//
//        if (K == 1) {
//            return "Mon";
//        } else if (K == 2) {
//            return "Tue";
//        } else if (K == 3) {
//            return "Wed";
//        } else if (K == 4) {
//            return "Thu";
//        } else if (K == 5) {
//            return "Fri";
//        } else if (K == 6) {
//            return "Sat";
//        } else if (K == 7) {
//            return "Sun";
//        }
        return map.get(K);
    }

    public static void main(String[] args) {
        System.out.println(solution("Wed", 5));
    }
}
