/**
 * String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than
 * the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * Hints:#92, #110
 */
package com.leo.cct189;
//a2b2c2 is fine
//a1b1c1 is not fine

//M1: check, stringbuilder
//M2: alp or hashmap can't, since a2 a3 can't merge


public class StringCompression_1_6 {

    public static String compressed(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i - 1));
            sb.append(count);
        }

        return sb.length() < str.length() ? sb.toString() : str;
    }

// keep in mind
    public static String compressed2(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;

            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        System.out.println(compressed2("aabcccccaaa"));
        System.out.println(compressed2("abc"));
    }
}