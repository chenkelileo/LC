package com.leo.cct189;

public class PalindromePermutation_1_4 {
    // ask: trim only space
    // boolean array works as well, hashset and hashmap as well
    // understand why and purpose of using which data structure: make it clean and easy

    public static boolean isPalindromePermutation(String str) {
        str = str.toLowerCase();
        int[] alps = new int[26]; //assume not case sensitive base on test case
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                continue;
            ;
            alps[str.charAt(i) - 'a']++;
        }

        // no more than one character that is odd
        int countOdd = 0;
        for (int i = 0; i < alps.length; i++) {
            if (alps[i] % 2 == 1) {
                countOdd++;
            }
            if (countOdd > 1) {
                return false;
            }
        }
        return true;
    }
    //t: O(n)
    //s: O(n)

    public static void main(String[] args) {
        //System.out.print('T' - 'A');
        System.out.println(isPalindromePermutation("Tact Coa"));
    }
}
