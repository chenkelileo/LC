package com.leo.jakeclass;

public class C14StringRemoveAdjacentRepeatedCharactersI {
    public static String RemoveAdjDup(char[] chars) {
        if (chars == null || chars.length == 0) {
            return null;
        }
        int slow = 1;
        int fast = 1;//the first element is special

        while (fast < chars.length) {
            if (chars[fast] == chars[slow]) { //or fast - 1
                fast++;
            } else {
                chars[slow++] = chars[fast++];
            }
        }
        return new String(chars, 0, slow);//2 para is length/count
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
        char[] chars = {'a', 'a','b','b','b'};
        System.out.println(RemoveAdjDup(chars));

    }
}
