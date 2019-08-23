package com.leo.jakeclass;

public class C3BsLastOccurrence {
    public int findLastOccurrence(int[] nums, int target) {
        //corner
        if (nums == null || nums.length == 0) {
            return -1;
        }

        //initialize
        int left = 0;
        int right = nums.length - 1;

        //iteration

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                //return
                left = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //return
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
