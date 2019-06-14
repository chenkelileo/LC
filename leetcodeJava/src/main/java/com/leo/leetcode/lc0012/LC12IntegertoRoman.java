/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: "III"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "IV"
 * Example 3:
 * <p>
 * Input: 9
 * Output: "IX"
 * Example 4:
 * <p>
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 * <p>
 * Input: 1994
 * Output: "MCMXCIV"
 * 1994 > 1000 M
 * 994 > 1000 994>900 CM
 * 94 > 900 94 > 500 94 > 400 94 > 100 94 > 90 XC
 * 4 > 90 4 > 50 4 > 40 4> 10 4> 10 4 > 9, 4 > 5 4 >=4 IV
 * 0
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
package com.leo.leetcode.lc0012;

public class LC12IntegertoRoman {
    public static String intToRoman(int num) {
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (num > 0) { //iterate until the number becomes zero, NO NEED to go until the last element in roman array
            while (num >= values[i]) {//use while not if for some cases such as 3
                num -= values[i];
                sb.append(strs[i]);
            }
            i++;
        }
        return sb.toString();
    }

    //t: O(n)
    //s: O(n) due to StringBuilder
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }
}
