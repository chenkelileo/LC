package com.leo.leetcode.lc0443;

public class LC0443StringCompression {

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        int s = 0;
        int f = 0;

        while (f < chars.length) {
            int count = 0;
            char temp = chars[f];
            while (f < chars.length && chars[f] == temp) {
                count++;
                f++;
            }
            //System.out.println(chars[s] + " " + chars[f - 1]);
            chars[s++] = temp;

            if (count != 1) {
                //integer to string
                String nums = Integer.toString(count);
                int i = 0;
                while (i < nums.length()) {
                    chars[s] = nums.charAt(i);
                    i++;
                    s++;
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {
        //System.out.println(compress(new char[]{'a', 'b', 'c'}));
        //System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }
}
