package com.leo.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OptimalUtilization {
    public static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, (i, j) -> i[1] - j[1]);
        Collections.sort(b, (i, j) -> i[1] - j[1]);
        List<int[]> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int m = a.size();
        int n = b.size();
        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if (sum > target) {
                j--;
            } else {
                if (max <= sum) {
                    if (max < sum) {
                        max = sum;
                        res.clear();
                    }
                    res.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int index = j - 1;
                    while (index >= 0 && b.get(index)[1] == b.get(index + 1)[1]) {
                        res.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                    }
                }
                i++;
            }
        }
        return res;
    }
//t= O(nlogn) n = max()
    //s = O(n) n = max()
    public static void main(String[] args) {
        List<int[]> a = new ArrayList<>();
        a.add(new int[]{1,8});
        a.add(new int[]{2,7});
        a.add(new int[]{3,14});
        a.add(new int[]{4,14});

        List<int[]> b = new ArrayList<>();
        b.add(new int[]{1,5});
        b.add(new int[]{2,10});
        b.add(new int[]{3,14});
        getPairs(a,b,20);
    }
}
