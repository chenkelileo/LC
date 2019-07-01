package com.leo.leetcode.lc0217;

import java.util.Arrays;
import java.util.HashSet;

public class LC217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    // brute force
    //
    public boolean containsDuplicate3(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if(!set.add(num))
                return true;
            //if (set.contains(num))
              //  return true;
            //set.add(num);
        }
        return false;
    }
     public static boolean containsDuplicate4(int[] nums){
        return nums.length != Arrays.stream(nums).distinct().count();
    }


    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(2);
        set.add(2);
        System.out.println(containsDuplicate4((new int[]{1})));
    }
}
