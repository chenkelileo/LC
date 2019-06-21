package com.leo.leetcode.lc0028;

public class LC28ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) // order matter "" "" return 0
            return 0;
        if (haystack == null || haystack.length() == 0)
            return -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length())
                return i;
        }

        return -1;
    }
}
