/**
 * 167. Two Sum II - Input array is sorted
 * Easy
 * <p>
 * 891
 * <p>
 * 377
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
package com.leo.leetcode.lc0167;

public class LC167TwoSumIIInputarrayissorted {
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return new int[]{-1, -1};
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right + 1};
            else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    // T: O(n)
    // S: O(1)
    public static void main(String[] args) {
        int[] in = {2, 7, 11, 15};
        int[] out = twoSum(in, 9);
        for (int i : out) {
            System.out.println(i);
        }
    }
}
