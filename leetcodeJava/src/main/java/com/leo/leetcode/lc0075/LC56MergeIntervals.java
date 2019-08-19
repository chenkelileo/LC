/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * i   j
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
package com.leo.leetcode.lc0075;

import java.util.*;


//class Interval {
//    int start;
//    int end;
//    Interval() { start = 0; end = 0; }
//    Interval(int s, int e) { start = s; end = e; }
//}
public class LC56MergeIntervals {
//    public List<Interval> merge(List<Interval> intervals) {
//
//    }

    public static int[][] merge(int[][] intervals) {
        //corner
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        //initialize
        ArrayList<int[]> res = new ArrayList<>();

        //function call
        //step1: sort

//        Collections.sort(intervalss, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return 0;
//            }
//        });
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] i1, int[] i2) {
//                return i1[0] > i2[0] ? 1 : -1;
//            }
//        });

        //Arrays.sort(intervals, Comparator.comparing((int[] i) -> i[0])); //if desc .reversed()

        Arrays.sort(intervals, (int[] i1, int[] i2) -> i1[0] - i2[0]); // ascending order
        res.addAll(Arrays.asList(intervals));
//        Collections.sort(res, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] > o2[0] ? 1 : -1;
//            }
//        });
        //step2: merge
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i)[1] >= res.get(i + 1)[0]) {
                res.get(i)[1] = Math.max(res.get(i)[1], res.get(i + 1)[1]);
                res.remove(i + 1);
                i--;
            }
        }


        //return
        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(arr);

    }
}
