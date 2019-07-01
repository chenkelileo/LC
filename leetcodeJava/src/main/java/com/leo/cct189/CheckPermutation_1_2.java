package com.leo.cct189;

public class CheckPermutation_1_2 {
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[128];
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
        System.out.println(permutation("gody","dogy"));
    }
}
