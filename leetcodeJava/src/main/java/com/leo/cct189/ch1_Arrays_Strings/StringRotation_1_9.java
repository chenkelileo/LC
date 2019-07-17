/**
 * String Rotation:Assumeyou have a method isSubstringwhich
 * checks if one word is a substring of another. Given two strings,
 * sl and s2, write code to check if s2 is a rotation of sl using only one call
 * to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
 */
package com.leo.cct189.ch1_Arrays_Strings;
// After reviewing all 3 hints, it is genius!!!!!


public class StringRotation_1_9 {
    //1. concatenate two str as newStr
    //2. call newStr.isSubstring(str)

    public static boolean isSubstring(String str1, String str2) {
        return true;
    }

    public static boolean isRotated(String str1, String str2) {
        //assume
        if (str1 == null || str1.length() == 0 || str1.length() != str2.length()) {
            return false;
        }

        String newStr = str1 + str2;


        return isSubstring(newStr, str1);
    }

    //t: O(A+B) -> O(n) depends on t of isSubstring method
    //s: O(1)

    public static void main(String[] args) {

    }
}
