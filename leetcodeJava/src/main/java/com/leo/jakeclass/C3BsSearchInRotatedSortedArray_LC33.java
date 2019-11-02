package com.leo.jakeclass;

public class C3BsSearchInRotatedSortedArray_LC33 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int offset = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (left == right) {
                offset = left;
                break;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int newLeft = 0;
        int newRight = nums.length - 1;

        while (newLeft <= newRight) {
            int newMid = newLeft + (newLeft + newRight) / 2;
            int mid = (newMid + offset) % nums.length;
            if (target > nums[mid]) {
                newLeft = newMid + 1;
            } else if (target < nums[mid]) {
                newRight = newMid - 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums ={4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }
}