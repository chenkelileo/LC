package com.leo.jakeclass;

public class C11DpJumpGame_LC55 {
    public static boolean canJump(int[] nums) {
        //corner
        if (nums == null || nums.length == 0) {
            return false;
        }
        //init
        int[] M = new int[nums.length];

        //dp

        //base
        M[0] = nums[0];

        //induction
        for (int i = 1; i < nums.length; i++) {
            M[i] = Math.max(M[i - 1] - 1, nums[i]);
            if (M[i] == 0) {
                return false;
            }

        }
        //return
        return true;
    }

    public static void main(String[] args) {
        int[] in = {3, 2, 1, 0, 4};
        System.out.println(canJump(in));
    }
}
