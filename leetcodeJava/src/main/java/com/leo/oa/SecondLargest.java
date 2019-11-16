package com.leo.oa;

import java.util.Arrays;
import java.util.Collections;

public class SecondLargest {
    //sort
    public static int findSecondLargest_test(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return Integer.MIN_VALUE;
        }

        Arrays.sort(arr);
        int count = 0;
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] > arr[i - 1]) {
                count++;
            }
            if (count == 1
            )
                return arr[i - 1];
        }
        return Integer.MIN_VALUE;
    }

    public static int findSecondLargest_test2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return Integer.MIN_VALUE;
        }

        int first = arr[0];
        int second = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > first) {
                second = first;
                first = arr[i];
            } else if(arr[i] < first && arr[i] > second) {
                second = arr[i];
            }
        }
        return second;

    }








    public static int findSecondLargest(int[] arr) {
        //corner case
        if (arr == null || arr.length < 1) {
            return Integer.MIN_VALUE;
        }

        //initialize
        int sec = Integer.MIN_VALUE;
        int first = Integer.MIN_VALUE;

        //iteration
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                sec = first;
                first = arr[i];
            } else if (arr[i] < first && arr[i] > sec) {
                sec = arr[i];
            }
        }

        //return
        if (sec == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return sec;
        }

    }

    public static void main(String[] args) {
        int[] a = {12, 35, 1, 10, 34, 1};
        int[] b = {10, 5, 10};
        int[] c = {10, 10, 10};
        System.out.println(findSecondLargest_test2(a));
        System.out.println(findSecondLargest_test2(b));
        System.out.println(findSecondLargest_test2(c));
    }

}
