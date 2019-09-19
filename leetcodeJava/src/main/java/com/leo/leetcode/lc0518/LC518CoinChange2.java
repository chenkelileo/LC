package com.leo.leetcode.lc0518;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC518CoinChange2 {
    public static int change(int amount, int[] coins) {
        //base case
        if (coins == null || coins.length == 0) {
            return -1;
        }
        //init
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //function call
        dfs(results, list, coins, amount, 0);
        //return
        return results.size();
    }

    private static void dfs(List<List<Integer>> results, List<Integer> list, int[] coins, int remain, int index) {
        //base case
        if (index == coins.length) {
            if (remain == 0) results.add(new ArrayList<>(list));
            return;
        }

        //recursion call
        int max = remain / coins[index];
        for (int i = 0; i <= max; i++) {
            list.add(i);
            dfs(results, list, coins, remain - coins[index] * i, index + 1);
            list.remove(list.size() - 1);
        }

    }

    //to be continue with dp

    public static void main(String[] args) {
        System.out.println(change(6, new int[]{2, 1}));
    }
}
