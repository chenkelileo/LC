/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * <p>
 * p w w k e w
 * s
 * e
 * <p>
 * {key}
 * {k,e}
 * <p>
 * res = 3
 */
package com.leo.leetcode.lc0003;

import java.util.HashSet;

public class LC3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        //corner
        if (s == null || s.length() == 0) {
            return 0;
        }

        //initialize
        HashSet<Character> set = new HashSet<>();
        int start = 0, end = 0, res = 0;

        //iteration
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                res = Math.max(res, set.size());
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        //return
        return res;
    }

    public static void main(String[] args) {

    }

}
