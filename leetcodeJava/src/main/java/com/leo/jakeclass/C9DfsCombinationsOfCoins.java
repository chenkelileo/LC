package com.leo.jakeclass;

import java.util.ArrayList;
import java.util.List;

public class C9DfsCombinationsOfCoins {
    public static List<List<Integer>> combinations(int target, int[] coins) {
        // Corner case
        if (coins == null || coins.length == 0) return new ArrayList<>();

        // Initialize
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        // Function call
        dfs(result, temp, coins, target, 0);

        // Return result
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> temp, int[] coins, int remain, int index) {
        // base case
        if (index == coins.length) {
            if (remain == 0) result.add(new ArrayList<>(temp));
            return;
        }

// dfs recursion
        int max = remain / coins[index];
        for (int i = 0; i <= max; i++) {
            temp.add(i);
            dfs(result, temp, coins, remain - i * coins[index], index+1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
       combinations(4, new int[]{2,1});
    }

}
