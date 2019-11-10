package com.leo.leetcode.lc0238;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class LC238ProductofArrayExceptSelf {
    public int[] productExceptSelf_best(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] post = new int[len];
        int[] res = new int[len];
        pre[0] = 1;
        post[len - 1] = 1;

        for(int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        for(int i = len - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < len; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }
    public int[] productExceptSelf_Space1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = len - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            res[i] = res[i] * right;
        }
        return res;
    }
    public static int[] productExceptSelf(int[] nums) {
        //corner
        if (nums == null) {
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
        for (int i = 1; i <= len; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        for (int i = len - 1; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i];
        }

        for (int i = 0; i < len; i++) {
            result[i] = pre[i] * post[i + 1];
        }
        //return
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,1, 2, 3, 4};

//        Arrays.sort(arr, reverse );

//        Arrays.sort(arr, Comparator.reverseOrder());
        Arrays.sort(arr);
        System.out.println(arr[0]);
        productExceptSelf(arr);
    }
}
