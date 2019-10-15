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

import java.util.*;

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


    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //3,2,4  t=6
            //3,3,2, still make sense
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};// 1st iteration has nothing in map
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

    public static int twoSumUniquePair(int[] nums, int target) {
        //initialize
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> seen = new HashSet<>();
        int res = 0;
        //iterate
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                if (!seen.contains(target - nums[i])) {
                    res++;
                    seen.add(target - nums[i]);
                    seen.add(nums[i]);
                }
            }
            set.add(nums[i]);
        }
        //return
        return res;
    }

    public static int[] findPairWithLargestNumber(int[] nums, int target) {
        //initialize
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int[] res = new int[2];
        //iterate
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (nums[i] > max || nums[map.get(target - nums[i])] > max ) {
                    res[0] = map.get(target - nums[i]);
                    res[1] = i;
                    max = Math.max(res[0], res[1]);
                }
            }
            map.put(nums[i], i);
        }
        //return
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {20, 50, 40, 25, 30, 10};
        int[] res = findPairWithLargestNumber(nums, 90 - 30);
        System.out.println(Arrays.toString(res));
    }


}
