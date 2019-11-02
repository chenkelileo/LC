/**
 * First Occurrence
 * Given a target integer T and an integer array A sorted in ascending order,
 * find the index of the first occurrence of T in A or return -1 if there is no such index.
 * Assumptions
 * There can be duplicate elements in the array.
 * Examples
 * A = {1, 2, 3}, T = 2, return 1
 * A = {1, 2, 3}, T = 4, return -1
 * 0  1  2  3  4  5  6
 * A = {1, 2, 2, 2, 2, 2, 3}, T = 1, return 1
 * l
 * m
 * r
 * <p>
 * Corner Cases
 * What if A is null or A of zero length? We should return -1 in this case.
 * <p>
 * 1,2,2,2,3   T = 2
 * L
 * R
 * M
 */
package com.leo.jakeclass;

public class C3BsFirstOccurrence {
//    public int findFirstOccurrenceTest(int[] nums, int target) {
//        //corner case
//
//        //init
//        int left = 0;
//        int right = nums.length - 1;
//
//        //iter
//        while (left < right - 1) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                right = mid;
//            } else if (nums[mid] > target) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        //return
//        if(nums[left] == target) {
//            return left;
//        } else if(nums[right] == target) {
//            return right;
//        } else{
//            return -1;
//        }
//    }


    public int findFirstOccurrence(int[] nums, int target) {
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
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //return
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}
