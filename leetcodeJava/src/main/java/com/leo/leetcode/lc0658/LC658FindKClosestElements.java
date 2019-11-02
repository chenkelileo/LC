/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 * UPDATE (2017/9/19):
 * The arr parameter had been changed to an array of integers (instead of a list of integers). Please reload the code definition to get the latest changes.
 */
package com.leo.leetcode.lc0658;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC658FindKClosestElements {
    //from closet to not closet
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        //corner case
        if (arr == null || arr.length < 1) {
            return null;
        }

        //initialize
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        //iteration // try know binary search api
        //step 1: find closet
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid]) {
                left = mid; // 2 2 2
            } else if (x > arr[mid]) {
                left = mid;
            } else {
                //right = mid;
                break;
            }
        }
        //step 2:
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                list.add(arr[right++]);
            } else if (right >= arr.length) {
                list.add(arr[left--]);
            } else if (Math.abs(x - arr[left]) > Math.abs(arr[right] - x)) {
                list.add(arr[right++]);
            } else {
                list.add(arr[left--]);
            }
        }

        // step 3:
        Collections.sort(list);

        //return
        return list;
    }

   /** [1,2,3,4,5], k=4, x=3
        l
          r
        m

     */


    public static List<Integer> findClosestElements3(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x > arr[mid]) {
                if (x - arr[mid] > arr[mid + k] - x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                right = mid;
            }
        }
        int index = left;
        while (k != 0) {
            res.add(arr[index++]);
            k--;
        }
        return res;
    }

    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        // corner case
        if(arr == null || arr.length == 0) return null;

        // initialize
        int left = 0;
        int right = arr.length - 1;
        List<Integer> list = new ArrayList<>();

        // iteration
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if(x > arr[mid]) {
                left = mid;
            } else if (x < arr[mid]) {
                right = mid;
            } else { // target == array[mid]
                break;
            }
        }

        for(int i = 0; i < k; i++) {
            if(left >= 0 &&right < arr.length && Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                list.add(arr[right]);
                right++;
            } else if (left >= 0 && right < arr.length && Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                list.add(arr[left]);
                left--;
            } else if (left < 0 && right < arr.length) {
                list.add(arr[right]);
                right++;
            } else if (right >= arr.length && left>=0){
                list.add(arr[left]);
                left--;
            }
        }
        return list;

    }

    public static void main(String[] args) {
        findClosestElements(new int[]{1, 4, 6, 8}, 3, 3);
        findClosestElements(new int[]{1, 2, 3}, 2, 3);
    }
}
