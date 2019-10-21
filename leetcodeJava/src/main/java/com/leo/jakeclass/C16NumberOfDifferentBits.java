package com.leo.jakeclass;

public class C16NumberOfDifferentBits {
    public static int diffBits(int a, int b) {
        int result = a ^ b;
        int count = 0;
        while (result != 0) {
            if ((result & 1) == 1) {
                count++;
            } // count += (result & 1);
            result = result >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(diffBits(-5, -8));
    }


}
