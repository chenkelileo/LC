/**
 * Palindrome Permutation: Given a string, write a function to check
 * if it is a permutation of a palindrome. A palindrome is a word or
 * phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco eta", etc.) Hints:#106,#121,#134,#136
 */

package com.leo.cct189.ch1_Arrays_Strings;

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
