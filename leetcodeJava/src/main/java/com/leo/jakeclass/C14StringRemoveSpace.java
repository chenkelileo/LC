package com.leo.jakeclass;

public class C14StringRemoveSpace {
    public static String removeSpace(String input) {
        char[] chars = input.toCharArray();
        int i = 0;
        int j = 0;
        while (j < input.length() && chars[j] == ' ') {
            j++;
        }

        while(j < input.length()) {
            while (j < input.length() && chars[j] != ' ') {
                chars[i++] = chars[j++];
            }
                chars[i++] = ' ';

            while (j < input.length() && chars[j] == ' ') {
                j++;
            }

        }
        return new String(chars, 0, i);
    }

    public static void main(String[] args) {
        System.out.println(removeSpace("   I    love  Jake   "));
        System.out.println(removeSpace("   I    love  Jake"));
    }
}
