package com.leo.jakeclass;

public class C11DpLongestAscendingSubArray {
    //t:O(n)
    //s:O(n)
    public static int longest(int[] array) {
        //corner case
        if (array == null || array.length == 0) {
            return 0;
        }

        //initialize
        int M[] = new int[array.length];
        //dp

        //base case
        M[0] = 1;
        int max = M[0];//or max = 1
        //induction
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                M[i] = M[i - 1] + 1;
            } else {
                M[i] = 1;
            }
            max = Math.max(M[i], max);
        }

        //return
        return max;
    }
    //t:O(n)
    //s:O(1)
    public static int longest2(int[] array) {
        //corner case
        if (array == null || array.length == 0) {
            return 0;
        }

        //initialize
        int m1;

        //dp

        //base case
        m1 = 1;
        int max = m1;//or max = 1

        //induction
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                m1 = m1 + 1;
            } else {
                m1 = 1;
            }
            max = Math.max(m1, max);
        }

        //return
        return max;
    }

    public static void main(String[] args) {
        int[] in = {7, 2, 3, 1, 5, 8, 9, 6};
        System.out.println(longest2(in));
    }
}
