package com.leo.jakeclass;

public class passByCopyOfReference {
    static void test(int[] arr) {
        int[] b = arr;
        arr = new int[] {4,5,6};
        b[0] = 10;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        test(arr);
        System.out.println(arr[0]);//10
    }

}
