package com.leo.leetcode.lc0046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC46_Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0) {
            return null;
        }
        //init
        List<List<Integer>> result = new ArrayList<>();
        //List<Integer> list = new ArrayList<>();
        //function call
        dfs(nums, result, 0);
        //return
        return result;
    }

    private static void dfs(int[] nums, List<List<Integer>> result, int index) {
        //base case
        if (index == nums.length) {
            List<Integer> intList = new ArrayList<Integer>();
            for (int i : nums) {
                intList.add(i);
            }
            result.add(intList);
            return;
        }
        //recursion
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(nums, result, index + 1);
            swap(nums, index, i);
        }
    }

    private static void swap(int[] nums, int a, int b) {//need to pass nums
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }
}
