package com.leo.leetcode.lc0179;


import java.util.Arrays;

public class LC179LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> {
            return (b + a).compareTo(a + b);

        });

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        String out = sb.toString();

        boolean isAllZeros = true;
        for(int i = 0; i < out.length(); i++){
            if(out.charAt(i) != '0'){
                isAllZeros = false;
            }
        }
        if(isAllZeros){
            out = "0";
        }

        return out;

    }
}
