package com.leo.leetcode.lc0409;

import java.util.HashMap;
import java.util.HashSet;

public class LC409LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count += 2;
            } else {
                set.add(c);
            }
        }
        if (set.size() == 0) {
            return count;
        } else {
            return count + 1;
        }
    }
}
//t: O(n)
//s: O(n)
// set contain is t: O(1)