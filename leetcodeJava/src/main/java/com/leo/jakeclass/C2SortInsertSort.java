package com.leo.jakeclass;

public class C2SortInsertSort {

    public static void insertSort(int[] arr) {
        //corner

        //init

        //iter
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i ;
            for (; j > 0; j--) {
                if (arr[ j - 1] > temp) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = temp;

        }
        //return
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 1, 2, 4, 7};
        insertSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }

    }
}
