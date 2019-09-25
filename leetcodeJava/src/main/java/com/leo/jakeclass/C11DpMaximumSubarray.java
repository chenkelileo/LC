package com.leo.jakeclass;

public class C11DpMaximumSubarray {
    public static int maxSubArray(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //initialize
        int m;
        int max = nums[0];
        //dp

        //base case
        m = nums[0];
        //induction
        for (int i = 1; i < nums.length; i++) {
            if (m > 0) {
                m = m + nums[i];
            } else {
                m = nums[i];
            }
            max = Math.max(max, m);
        }
        //return
        return max;
    }
}
