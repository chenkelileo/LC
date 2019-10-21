package com.leo.jakeclass;

//stable
//Time: O(step 1 + step 2) = O(n log n + 2n - 1) = O(n log n)
//        Space: O(recursion tree height  (+ helper array)) = O(log n ( + n))

public class C2SortMergeSort {
    public static void mergeSort(int[] arr) {
        //corner case
        if (arr == null || arr.length <= 1) {
            return;
        }
        //init
        int[] temp = new int[arr.length];
        //function call
        helper(arr, temp, 0, arr.length - 1);
        //return
        return;
    }

    private static void helper(int[] arr, int[] temp, int left, int right) {
        //base case
        if (left == right) {
            return;
        }
        //recursion call
        int mid = left + (right - left) / 2;
        helper(arr, temp, left, mid);
        helper(arr, temp, mid + 1, right);

        merge(arr, temp, left, mid, right);

        return;//check if need: same
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        //init
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int k = left;
        int j = mid + 1;

        //iter
        while(i <= mid && j <= right) {
            if(temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while(i <= mid) {
            arr[k++] = temp[i++];
        }
        //return
        return;//check if need : same
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,8,6,4,2,0};
        mergeSort(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }

}
