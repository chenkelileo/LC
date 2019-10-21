package com.leo.jakeclass;

public class C15StringIIReverseString {// or append directly
    public static String shift(char[] chars, int n) {
        int r = n % (chars.length);
        int l = (chars.length) - r;

        String str = new String(chars);
        String strL = str.substring(0, l);
        String strR = str.substring(l, str.length());
        char[] charsL = strL.toCharArray();
        char[] charsR = strR.toCharArray();

        reverse(charsL);
        reverse(charsR);
        String strLResult = new String(charsL);
        String strRResult = new String(charsR);
        String result = strLResult + strRResult;
        char[] cResult = result.toCharArray();
        reverse(cResult);
        return new String(cResult);
    }

    public static String shift2(String str, int n) {
        int r = n % (str.length());
        return str.substring(str.length() - r) + str.substring(0, str.length() - r);

    }

    public static void shift3(char[] chars, int n) {
        int r = n % (chars.length);
        reverse2(chars, 0, chars.length - 1 - r);
        reverse2(chars, chars.length - r, chars.length - 1);
        reverse2(chars, 0, chars.length - 1);
    }
    public static String reverseSentence(String s) {
        char[] chars = s.toCharArray();
        reverse(chars);
        String rStr = new String(chars);
        String[] strs = rStr.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            char[] cs = str.toCharArray();
            reverse(cs);
            String temp = new String(cs);
            sb.append(temp + " ");
        }
        return sb.toString();
    }

    public static String reverseSentence2(String s) {
        char[] cs = s.toCharArray();
        reverse2(cs, 0, s.length() - 1);

        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if(j == s.length() - 1 ||  cs[j] == ' ' ) {
                reverse2(cs, i, j - 1);
                j++;
                i = j;
            } else {
                j++;
            }

        }
        return new String(cs);
    }

    public static void reverse2(char[] chars, int a, int b) {
        //iteration
        while (a < b) {
            swap(chars, a++, b--);
        }
        //return
    }

    public static void reverse(char[] chars) {
        //corner case
        if (chars == null || chars.length == 0) {//use string to test
            return;
        }

        //init
        int i = 0;
        int j = chars.length - 1;

        //iteration
        while (i < j) {
            swap(chars, i++, j--);
        }
        //return
    }

    private static void swap(char[] strs, int i, int j) {
        char temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'p', 'p', 'l'};
        reverse(chars);
        String str = new String(chars);
        System.out.println(str);
        String str1 = "apple";

        String str2 = "I Love Leo";

        System.out.println(reverseSentence2(str2));

        char[] char2 = {'a', 'b', 'c', 'd', 'e', 'f'};

        shift3(char2, 8);

    }
}
