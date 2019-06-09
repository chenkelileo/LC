/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */

package com.leo.leetcode.lc0014;

public class LC14LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) { // Does it necessary to sort, it costs
        if (strs == null || strs.length == 0)
            return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] s= {"flower","flow","flight"};
        System.out.print(longestCommonPrefix2(s));

    }
}
