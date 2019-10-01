package com.leo.jakeclass;

public class C11DpJumpGameII_LC45 {
    public static int jump(int[] nums) {
        //corner
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //init
        int[] M = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            M[i] = Integer.MAX_VALUE;
        }

        //dp

        //base case
        M[M.length - 1] = 0;
        //induction
        for (int i = M.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j < M.length && M[j] != -1) {
                    M[i] = Math.min(M[i], M[j] + 1);
                }
            }
            if (M[i] == Integer.MAX_VALUE) {
                M[i] = -1;
            }
        }

        //return
        return M[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }
}
