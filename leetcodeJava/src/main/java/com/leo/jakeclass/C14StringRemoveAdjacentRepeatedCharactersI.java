package com.leo.jakeclass;

public class C14StringRemoveAdjacentRepeatedCharactersI {

    public static String RemoveAdjDup_test(char[] chars) {
        //corner
        if (chars == null || chars.length <= 1) {
            return new String(chars);
        }

        //init
        int s = 0;
        int f = 0;
        //iter
        while (f < chars.length) {
            if (chars[s] == chars[f]) {
                f++;
            } else {
                s++;
                chars[s] = chars[f];
                f++;
            }
        }

        //return
        return new String(chars, 0, s + 1);
    }

    public static String RemoveAdjDup_test2(char[] chars) {
        //corner
        if (chars == null || chars.length <= 1) {
            return new String(chars);
        }

        //init
        int s = 0;
        int f = 0;
        //iter
        while (f < chars.length) {
            char temp = chars[f];//store index f here
            while (f < chars.length && chars[f] == temp) {
                f++;//compare with itself and it makes sure not -1
            }
            chars[s++] = temp;
        }

        //return
        return new String(chars, 0, s);
    }


//    public static String RemoveAdjDup2(char[] chars) {
//        if (chars == null || chars.length == 0) {
//            return null;
//        }
//        int slow = 0;
//        int fast = 0;
//
//        while (fast < chars.length) {
//            if (chars[fast] == chars[slow]) {
//                fast++;
//            } else {
//                chars[++slow] = chars[fast++];
//            }
//        }
//        return new String(chars, 0, slow + 1);//2 para is length/count
//    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        System.out.println(RemoveAdjDup_test2(chars));

    }
}
