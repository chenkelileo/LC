package com.leo.leetcode.lic0846;

import java.util.Arrays;
import java.util.Comparator;

public class LIC846MultiSort {
    public int[][] multiSort(int[][] array){
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                else{
                    return o2[1] - o1[1];
                }
            }
        });
        return array;
    }

    public int[][] multiSort2(int[][] array){
        Arrays.sort(array, (a,b) ->{
           if (a[1] == b[1]){
               return a[0] - b[0];
           } else{
               return b[1] - a[1];
           }
        });
        return array;
    }

}
// o1, o2
// if return negative: o1 is smaller than o2
// if return positve: o1 is bigger than o2

//default
//3, 2
//3-2
//then 2, 3

// if want to desc
// let o2 - o1