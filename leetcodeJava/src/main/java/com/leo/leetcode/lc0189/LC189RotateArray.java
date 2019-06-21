package com.leo.leetcode.lc0189;

public class LC189RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        int temp, pre;
        for(int i = 0; i < k; i++){
            pre = nums[nums.length - 1];
            for(int j = 0; j < nums.length ; j++){
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
