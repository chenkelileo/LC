/**
 * Given two strings,write a method to decide if one is a permutation of the
 * other.
 * Hints: #7, #84, #722, #737
 */

package com.leo.cct189;

//assume only lower and upper and case sensitive
public class CheckPermutation_1_2 {
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[128]; //there is a gap between upper letters and lower letters
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) { //ascii
            int c = t.charAt(i); // (int) or ch - 'a'?
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(permutation("gody","dog"));
    }
}
