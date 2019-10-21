package com.leo.jakeclass;

import java.util.Random;

public class C2SortQuickSort {
    public static int[] quickSort(int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) return nums;

        // initialize
        // function call
        quickSortRecursive(nums, 0, nums.length - 1);
        // return array
        return nums;
    }

    static void quickSortRecursive(int[] array, int left, int right) {
        // base case
        if (left >= right) return;

        // partition
        Random rand = new Random();
        int pivot = left + rand.nextInt(right - left);
        swap(array, pivot, right);

        int i = left;
        int j = right - 1;
        while (j >= i) {
            if (array[i] > array[right]) {
                swap(array, i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(array, i, right);

// recursion call
        quickSortRecursive(array, left, i - 1);
        quickSortRecursive(array, i + 1, right);
        return;
    }

    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {

    }
}
