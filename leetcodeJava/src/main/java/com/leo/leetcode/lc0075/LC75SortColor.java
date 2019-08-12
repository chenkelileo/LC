package com.leo.leetcode.lc0075;

public class LC75SortColor {

    public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++] = i;
            }
        }

    }


    public static void sortColors2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, right, i);
                right--;
            }
        }
    }


    public static void swap(int[] nums, int a, int b) {//check nums reference; pass nums[a]
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }
}
