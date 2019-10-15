package com.leo.amazon;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumClosest {
    public static int[] get2SumClosest(int[] movie_duration, int d) {
        //corner
        if (movie_duration == null || movie_duration.length == 0) {
            return new int[]{-1, -1};
        }
        //init
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < movie_duration.length; i++) {
            map.put(movie_duration[i], i);
        }
        Arrays.sort(movie_duration);
        int l = 0;
        int r = movie_duration.length - 1;
        int max = Integer.MIN_VALUE;
        int[] res = new int[2];

        //iter
        while (l < r) {
            int sum = movie_duration[l] + movie_duration[r];
            if ((sum > max || (sum == max && Math.max(movie_duration[l], movie_duration[r]) > Math.max(res[0], res[1]))) && sum <= d) {
                max = sum;
                res[0] = movie_duration[l];
                res[1] = movie_duration[r];
            }
            if (sum > d) {
                r--;
            } else {
                l++;
            }
        }
        if (map.containsKey(res[0]) && map.containsKey(res[1])) {
            res[0] = map.get(res[0]);
            res[1] = map.get(res[1]);
            if (res[0] == res[1]) {
                return new int[]{-1, -1};
            }
            return res;
        } else return res;
        // Time complexity is O(nlogn), space complexity is O(n);
//        res[0] = map.get(res[0]);
//        res[1] = map.get(res[1]);
//        return res;

    }

    public static void main(String[] args) {
        int[] movie_duration1 = {90, 85, 75, 60, 120, 150, 125};
        int d1 = 250;
        int[] movie_duration2 = {90, 85, 75, 60, 155, 150, 125};
        int d2 = 250;
        System.out.println(Arrays.toString(get2SumClosest(movie_duration1, d1 - 30)));
        System.out.println(Arrays.toString(get2SumClosest(movie_duration2, d2 - 30)));
    }
}
