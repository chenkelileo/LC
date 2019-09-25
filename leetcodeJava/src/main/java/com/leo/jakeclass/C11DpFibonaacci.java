package com.leo.jakeclass;

//t: O(n)
//s: O(n)
public class C11DpFibonaacci {
    public static int fib(int n) {
        //corner case
        if (n <= 0) {
            return 0;
        }

        //initialize
        int[] M = new int[n + 1];

        //dp

        // base case
        M[0] = 0;
        M[1] = 1;

        //induction
        for (int i = 2; i < n + 1; i++) {
            M[i] = M[i - 1] + M[i - 2];
        }

        //return
        return M[n];
    }

    //choose this
    //t: O(n)
    //s: O(1)
    public static int fib2(int n) {
        //corner case
        if (n <= 0) {
            return 0;
        }

        //initialize

        //dp

        // base case
        int M1 = 0;
        int M2 = 1;
        int temp;

        //induction
        for (int i = 2; i < n + 1; i++) {
            temp = M2;
            M2 = M1 + M2;
            M1 = temp;
        }

        //return
        return M2;
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
    }
}
