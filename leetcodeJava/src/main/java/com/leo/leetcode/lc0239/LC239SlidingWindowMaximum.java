/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], 8 and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 * <p>
 * <p>
 * k = 3
 * 1 3 -1 -3 5 3 2 1
 * i
 * deque:  <-> 3 2 1<-> ... in descending order
 * result: 3, 3, 5, 5, 5, 3
 */


package com.leo.leetcode.lc0239;

import java.util.Deque;
import java.util.LinkedList;

public class LC239SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        //corner
        if (nums == null || nums.length == 0) {
            return null;
        }
        //initialize
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        //iteration
        for (int i = 0; i < nums.length; i++) {
            //remove out of range
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            //remove smaller numbers in k range
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }

        }

        //return
        return res;
    }

    public static void main(String[] args) {

    }
}
