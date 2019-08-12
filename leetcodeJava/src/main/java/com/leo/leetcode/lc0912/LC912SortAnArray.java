/**
 * 912. Sort an Array
 * Medium
 * <p>
 * 97
 * <p>
 * 110
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an array of integers nums, sort the array in ascending order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * -50000 <= A[i] <= 50000
 */
package com.leo.leetcode.lc0912;

public class LC912SortAnArray {

    //select sort
    //t:O(n^2)
    //s:O(1)
    public static int[] sortArray(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int minIndex = i;
            for(int j = i; j < nums.length; j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;

        }
        return nums;
    }

    //insert sort
    //t:O(n^2)
    //s:O(1)
    public static int[] sortArray2(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int newVal = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > newVal){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = newVal;
        }
        return nums;
    }

    public static void sortArray5(int[] nums){

        //i 是每次要插入的元素
        for(int i = 0; i < nums.length; i++){
            int j = 0; //j是已排好序的元素
            int temp = nums[i];
            for(;j < i; j++){
                if(nums[j] > nums[i]){
                    break;
                }
            }
            //移动 nums[j], nums[j+1],..., nums[i-1]
            for(int k = i -1; k >= j; k--){
                nums[k + 1] = nums[k]; //since position can be replaced
            }
            nums[j] = temp;

        }

    }


    //直接写

    public static void sortArray6(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int j = i - 1;
            int temp = nums[i];
            for(; j >= 0; j--){
                if(temp < nums[j]){
                    nums[j + 1] = nums[j];
                }
                else{
                    break;
                }
            }
            nums[j + 1] = temp;
        }
    }



    //bubble sort
    //t:O(n^2)
    //s:O(1)
    public static int[] sortArray3(int[] nums){
        for(int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i -1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    //bubble sort
    //t:O(n^2)
    //s:O(1) with flag to check
    public static int[] sortArray4(int[] nums){
        for(int i = 0; i < nums.length - 1; i++) {
            boolean isExchange = false;
            for (int j = 0; j < nums.length - i -1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    isExchange = true;
                }
            }
            if(!isExchange){
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] input = {5, 2, 3, 1};
        sortArray6(input);
        //output = sortArray3(input);
        //output = sortArray3(input);
        for (int i : input) {
            System.out.println(i);
        }
    }

}
