package com.leo.leetcode.lc0009;

public class LC9PalindromeNumber {
    public static boolean isPalindrome(int x){
        if(x < 0)
            return false;
        String s = Integer.toString(x);
        String rs = new StringBuffer(s).reverse().toString();
        if(s.equals(rs)) // equal here keep in mind
            return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-121));
    }

}
