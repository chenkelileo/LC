package com.leo.oa;

public class SecondLargest {
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
        int[] c = {10,10,10};
        System.out.println(findSecondLargest(a));
        System.out.println(findSecondLargest(b));
        System.out.println(findSecondLargest(c));
    }

}
