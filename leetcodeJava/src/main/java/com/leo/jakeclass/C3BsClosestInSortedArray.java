package com.leo.jakeclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C3BsClosestInSortedArray {
    public static int findClosestElements(int[] arr, int x) {
        //corner case
        if (arr == null || arr.length < 2) {
            return arr[0];
        }

        //initialize
        int left = 0;
        int right = arr.length - 1;

        //iteration // try know binary search api
        //step 1: find closet
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid]) {
                return mid;
            } else if (x > arr[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        //return
        if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
            return right;
        } else {
            return left;
        }

    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3},2));
        System.out.println(findClosestElements(new int[]{1,4,6},3));
        System.out.println(findClosestElements(new int[]{1,4,6},5));
        System.out.println(findClosestElements(new int[]{1,3,3,4},2));
    }
}
