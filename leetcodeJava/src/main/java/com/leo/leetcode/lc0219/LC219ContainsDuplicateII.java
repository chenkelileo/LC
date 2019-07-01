package com.leo.leetcode.lc0219;

import java.util.HashMap;
import java.util.HashSet;

public class LC219ContainsDuplicateII {
    // bruce force
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i <= k && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsNearbyDuplicate2(int[] nums, int k){
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
//        for(int i = 0; i < nums.length; i++){
//            if(!set.add(nums[i]) && set.size() )
//        }
        return false;
    }
    public static void main(String[] args) {

    }
}
