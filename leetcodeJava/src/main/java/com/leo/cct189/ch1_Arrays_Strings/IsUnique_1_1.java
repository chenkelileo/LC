/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use
 * additional data structures?
 * Hints: #44, #117, #132
 */
package com.leo.cct189.ch1_Arrays_Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class IsUnique_1_1 {
    //not easy to return position/ index
    // checking first unique and check first dups need to store all elements at very beginning: position matters

    //assume 128 ascii code

    public static boolean isUnique(String str) {
        if (str == null || str.length() == 0 || str.length() > 128)
            return false;

        char[] cs = str.toCharArray();
        Arrays.sort(cs);// change the original array->can't use to find first

//        for (char c : cs) {
//            System.out.println(c);
//        }

        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == cs[i - 1])
                return false;
        }
        return true;
    }
    //t:O(nlog(n)) since sort (quick/ merge)
    //s:O(n)



    // use hashset to check unique
    public static boolean isUnique2(String str){
        if (str == null || str.length() == 0 || str.length() > 128)
            return false;

        HashSet<Character> set = new HashSet<>();
        for(char c : str.toCharArray()){
            if(!set.add(c)){
                return false;
            }
        }
        return true;
    }
    //t: O(n)
    //s: O(n)

    public static void main(String[] args) {
        System.out.println(isUnique2("accd"));
    }
}
