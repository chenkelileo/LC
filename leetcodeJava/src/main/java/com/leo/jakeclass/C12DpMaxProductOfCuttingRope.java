package com.leo.jakeclass;

public class C12DpMaxProductOfCuttingRope {
    public static int maxRopd(int n) {
        //corner case
        if (n < 2) {
            return 1;
        }

        //init
        int[] M = new int[n + 1];

        //dp

        //base
        M[1] = 1;

        //induction
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                M[i] = Math.max(M[i], Math.max(M[j], j) * (i - j));
            }
        }
        //return
        return M[n];
    }

    public static void main(String[] args) {
        System.out.println(maxRopd(5));
    }
}
