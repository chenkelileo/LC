/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
package com.leo.leetcode.lc0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        //corner case
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        //initialize
//        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);//try, same as int[] o1 ascending order
        //Arrays.sort(intervals, Comparator.comparing(int[] i -> i[0]));
        Arrays.sort(intervals, new Comparator<int[]>() {//keep in mind this order only, and 1 means true
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return 0;
                else return (o1[0] - o2[0] > 0) ? 1 : -1;
            }
        });
        List<int[]> lists = new ArrayList<>();
        lists.addAll(Arrays.asList(intervals));// turn array to list together
        //iteration
        for (int i = 1; i < lists.size(); i++) {
            if (lists.get(i - 1)[1] >= lists.get(i)[0]) {
                lists.get(i - 1)[1] = Math.max(lists.get(i - 1)[1], lists.get(i)[1]);
                lists.remove(i);
                i--;
            }
        }
        //return
        return lists.toArray(new int[lists.size()][]);//case from integer to int
    }

    public static void main(String[] args) {
        Integer[] f = {1,2,3};
        List<Integer> aa = new ArrayList<>();
        aa.addAll(Arrays.asList(f));
        aa.add(1);
        aa.add(2);
        aa.set(2,5);
    }
}
