package com.leo.jakeclass;

public class C2SortSelectSort {
    public static void selectSort(int[] arr) {
        //corner
        if(arr == null || arr.length == 0) {
            return;
        }
        //init

        //iter
        for(int i = 0; i < arr.length; i++) {
            int min = arr[i]; // pay attention here not min_value
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    minIndex = j;

                }
            }
            swap(arr, i, minIndex);
        }
        //return
        return;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 12, 3};
        selectSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
