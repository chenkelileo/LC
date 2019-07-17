/**
 * Given two strings,write a method to decide if one is a permutation of the
 * other.
 * Hints: #1, #84, #122, #131
 */

package com.leo.cct189.ch1_Arrays_Strings;

//assume 128 ascii characters
//hashmap or sort since length is fixed
public class CheckPermutation_1_2 {
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //if use 128, than don't need to - 'A'
        int[] letters = new int[128]; //there is a gap between upper letters and lower letters
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) { //ascii
            int c = t.charAt(i); // (int)
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(permutation("gody", "dog"));
    }
}
