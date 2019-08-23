package com.leo.leetcode.lc0704;

public class LC704BinarySearch {
    public int search(int[] nums, int target) {
        //corner
        if (nums == null || nums.length == 0) {
            return -1;
        }

        //initalize
        int left = 0;
        int right = nums.length - 1;

        //iteration

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                //return
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //return
        return -1;
    }
}
