package com.leo.leetcode.lc0189;

public class LC189RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int temp, pre;
        for (int i = 0; i < k; i++) {
            pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }
    // t: O(k * n)
    //s: O(n)

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] temps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temps[(k + i) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temps[i];
        }
    }
    //t: O(n)
    //s: O(n)

    public void rotate3(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        k %= nums.length;
        nums = reverse(nums, 0, nums.length - 1);
        nums = reverse(nums, 0, k - 1);
        nums = reverse(nums, k, nums.length - 1);
    }

    public int[] reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
    //t: O(n)
    //t: O(1)
    public static void main(String[] args) {

    }
}
