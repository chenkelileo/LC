package com.leo.leetcode.lc0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 3)
            return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                int out = target - nums[i] - nums[j];

                while (left < right) {
                    if (nums[left] + nums[right] == out) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < out) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
