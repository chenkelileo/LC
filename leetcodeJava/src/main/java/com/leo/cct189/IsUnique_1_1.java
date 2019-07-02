/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 * Hints: #44, #7 7 7, #732
 */
package com.leo.cct189;

import java.util.Arrays;

public class IsUnique_1_1 {
    //not easy to return position/ index
    // checking first unique and check first dups need to store all elements at very beginning

    //assume only with lower and upper letters: no need assume for this one.

    public static boolean isUnique(String str) {
        if (str == null || str.length() == 0)
            return false;

        char[] cs = str.toCharArray();
        Arrays.sort(cs);

//        for (char c : cs) {
//            System.out.println(c);
//        }

        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == cs[i - 1])
                return false;
        }
        return true;
    }
    //t:o(nlog(n)) since sort (quick/ merge)
    //s:o(1)

    public static void main(String[] args) {
        System.out.println(isUnique("acd"));
    }
}
