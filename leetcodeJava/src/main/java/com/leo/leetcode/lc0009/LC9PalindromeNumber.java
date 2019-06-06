package com.leo.leetcode.lc0009;

public class LC9PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String s = Integer.toString(x);
        String rs = new StringBuffer(s).reverse().toString();
        if (s.equals(rs)) // equal here keep in mind
            return true;
        return false;
    }
// suggested
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int res = 0;
        int in = x;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        return res == in;
    }

    // compare half
    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    public static void main(String[] args) {
        // System.out.println(isPalindrome2(123));
        System.out.println(isPalindrome2(121));
        System.out.println(isPalindrome2(10));
        System.out.println(isPalindrome2(-121));
    }

}
