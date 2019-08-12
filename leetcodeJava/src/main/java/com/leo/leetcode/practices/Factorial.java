package com.leo.leetcode.practices;

public class Factorial {
    public static long factorialLoop(int in) {
        long res = 1;
        for(int i = 1; i <= in; i++){
            res *= i;
        }
        return res;
    }
    public static long factorialLoop2(int in){
        if(in == 1) {
            return 1;
        }
        else {
            return in * factorialLoop2(in - 1);
        }
    }

    public static void main(String[] args) {
        long d1 = System.currentTimeMillis();
        System.out.println(factorialLoop(40));
        long d2 = System.currentTimeMillis();
        System.out.println(d2 - d1);

        long d3 = System.currentTimeMillis();
        System.out.println(factorialLoop2(40));
        long d4 = System.currentTimeMillis();
        System.out.println(d4 - d3);
    }
}
