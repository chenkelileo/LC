/**
 * One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true pales, pale -> true pale, bale -> true pale, bake -> false Hints:#23, #97, #130
 */
package com.leo.cct189.ch1_Arrays_Strings;

import java.util.Arrays;
import java.util.HashMap;
//wrong
public class OneAway_1_5 {
    //check lens, if len - 1: return
    // sort (not applicable) or store in alp/ hashset/ hashmap
    //count one error

    //assume ascii 128

    public static boolean isOneEdit(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0
                || Math.abs(str1.length() - str2.length()) > 1) // assume if two strings are 0, return false;
            return false;

        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int[] alp1 = new int[128]; //try boolean as well: not applicable
        //int[] alp2 = new int[128];
        int countEdit = 0;

        for (int i = 0; i < str1.length(); i++) {
            alp1[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            alp1[str2.charAt(i)]--;

            if (alp1[str2.charAt(i)] < 0)
                countEdit++;

            if (countEdit > 1)
                return false;
        }
        return true;
    }
    //t: O(n)
    //t: O(n)

    public static boolean isOneEdit2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0
                || Math.abs(str1.length() - str2.length()) > 1) // assume if two strings are 0, return false;
            return false;

        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int countEdit = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            map.put(c, map.getOrDefault(c, -1) - 1);
            if (map.get(c) < 0)
                countEdit++;

            if (countEdit > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneEdit("pale", "ple"));
        System.out.println(isOneEdit("pales", "pale"));
        System.out.println(isOneEdit("pale", "bale"));
        System.out.println(isOneEdit("pale", "bake"));
    }
}
