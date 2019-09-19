package com.leo.leetcode.lc0078;

import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        //corner case
        if(nums == null || nums.length == 0) {
            return null;
        }
        //init
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        //function call
        dfs(nums, results, list, 0);
        //return
        return results;
    }

    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> list, int index) {
        //base case
        if(index == nums.length) {
            results.add(new ArrayList<>(list));//try only use list
            return;
        }
        //recursion
        list.add(nums[index]);
        dfs(nums,results, list,index + 1);
        list.remove(list.size() - 1);//index+1
        dfs(nums,results, list,index + 1);
    }
}
