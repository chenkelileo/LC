/**
 * Move 0s To The End I
 * Given an array of integers, move all the 0s to the right end of the array.
 * The relative order of the elements in the original array does not need to be maintained.
 * Assumptions:
 * The given array is not null.
 * Examples:
 * {1} --> {1}
 * {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
 *
 * 1, 1, 3, 0, 0
 *          l
 *         r
 *
 * 1, 3, 1, 0, 0
 *          s
 *               f
 *  1, 1, 0, 0, 0
 *        s
 *                f
 *  1, 0, 3, 0 , 1
 *     s
 *        f
 */

//non-zero value has the same order
//l pointer swap if find 0
package com.leo.jakeclass;

public class move0s {
    public void moveZeroes(int[] nums){
        //corner case
        if(nums == null || nums.length < 2){
            return;
        }
        //initialize
        int left = 0;
        int right = nums.length - 1;
        //iteration
        while(left <= right){
            if(nums[left] == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
            else{
                left++;
            }
        }
        //return
    }

    public void moveZeroesSameOrder2(int[] nums){
        //corner case
        if(nums == null || nums.length <2){
            return;
        }
        //initialize
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != 0){
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;//make sure before the pointer slow is all non 0s
            }
        }
    }

    public void moveZeros3(int[] nums) {
        //corner case
        if(nums == null || nums.length <2){
            return;
        }
        //initialize
        int slow = 0;

        //iteration
        for(int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != 0){
               nums[slow++] = nums[fast];
            }
        }
        while(slow < nums.length) {
            nums[slow++] = 0;
        }
        //return
    }
}
