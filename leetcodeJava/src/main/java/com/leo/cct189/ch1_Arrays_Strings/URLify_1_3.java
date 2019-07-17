/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the "true" length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith" Hints: #53, #118
 */
package com.leo.cct189.ch1_Arrays_Strings;

public class URLify_1_3 {
//    public static void replaceSpace(char[] sArray, int trueLength) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < trueLength; i++) {
//            if (sArray[i] != ' ')
//                sb.append(sArray[i]);
//            else {
//                sb.append("%20");
//            }
//        }
//        sArray = sb.toString().toCharArray(); // why it is void  ?
//        //System.out.println(sArray);
//    }
//    //t: O(n)
//    //s: O(n)

//    public static String replaceSpace3(char[] s_array, int trueLength) {
//        String str = new String(s_array);
//        return str.trim().replace(" ", "%20");
//    }

    //use this one
    public static void replaceSpace2(char[] sArray, int trueLength) {
        int end = sArray.length - 1;
        int trueEnd = trueLength - 1;

        while (trueEnd >= 0) {
            if (sArray[trueEnd] == ' ') {
                sArray[end] = '0';
                sArray[end - 1] = '2';
                sArray[end - 2] = '%';
                end -= 3;
                trueEnd--;
            } else {
                sArray[end] = sArray[trueEnd];
                end--;
                trueEnd--;
            }
        }
    }

    //t:O(n)
    //s:O(1) in place, so it changes original sArray
    public static void main(String[] args) {
        char[] sArray = "Mr John Smith    ".toCharArray();
        replaceSpace2(sArray, 13);
        System.out.println(new String(sArray));
//        char[] sArray = "Mr John Smith    ".toCharArray();
//        replaceSpace2(sArray, 13);
//        System.out.println(new String(sArray));
    }
}
