/**
 * 1. Two Sum
 * Easy
 * <p>
 * 10845
 * <p>
 * 366
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2,7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * (2), 9-7 = 2 in hashmap return
 * (2) 9 - 3 not in hashmap, add 3 and move to next
 */
package com.leo.leetcode.lc0001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
    // T: O(n) = n^2
    // S: O(n) = 1


    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //3,2,4  t=6
            //3,3,2, still make sense
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i); //put add statement down below.
        }
        return new int[]{-1, -1};
    }

    // T: O(n) = n hashmap lookup costs only O(1)
    // S: O(n) = n


//2, 7, 11, 15

//map <nums[i]:i>

    public int[] twoSum_test(int[] nums, int target) {
        //initialize
        HashMap<Integer, Integer> map = new HashMap<>();
        //iterate
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        //return
        return new int[]{-1, -1};
    }

    //if can have more than 2 solutions
    public static List<int[]> twoSum_multiSolution(int[] nums, int target) {
        //corner
        //initialize
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        //iteration
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
               map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            } else {
                for (int index : map.get(target - nums[i])) {
                    result.add(new int[]{index, i});
                }
            }
        }

        //return
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3};
        twoSum_multiSolution(nums,5);
    }


}
