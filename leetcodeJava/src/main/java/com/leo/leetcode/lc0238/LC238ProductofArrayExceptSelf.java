package com.leo.leetcode.lc0238;

public class LC238ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        //corner
        if(nums == null) {
            return nums;
        }
        //initialize
        int len = nums.length;
        int[] pre = new int[len + 1];
        pre[0] = 1;
        int[] post = new int[len + 1];
        post[len] = 1;
        int[] result = new int[len];

        //iteration
        for(int i = 1; i <= len; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        for(int i = len - 1; i >= 0; i--){
            post[i] = post[i + 1] * nums[i];
        }

        for(int i = 0; i < len; i++){
            result[i] = pre[i] * post[i + 1];
        }
        //return
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        productExceptSelf(arr);
    }
}