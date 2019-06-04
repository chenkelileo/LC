/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * 123/10
 * 12    3
 * 1     32
 * 0     321
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
package com.leo.leetcode.lc0007;

public class LC7ReverseInteger {
    public static int reverse(int x) {
        long res = 0; // if not initalize
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
        }

        return (int) res;
    }

    // time: O(n)
    // space: O(1)
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
