/**
 * 15. 3Sum
 * Medium
 * <p>
 * 3829
 * <p>
 * 427
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
package lc0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //check dups
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            while (left < right) {
                //check dups

                //while (left < right && nums[left] == nums[left + 1] ) left++;
                //while (left < right && nums[right] == nums[right - 1]) right--;
                if (nums[left] + nums[right] == target) {

                    // while (left < right && nums[left] == nums[left + 1]) left++;
                    //while (left < right && nums[right] == nums[right - 1]) right--;
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    // res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                    //right
                    // while (left < right && nums[left] == nums[left - 1]) left++;
                    //while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (nums[left] + nums[right] < target) {
                    //while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;

                } else {
                    //while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;

                }
                //while (left > 0 && left < right && nums[left] == nums[left - 1]) left++;
                //while (right < nums.length - 1 && left < right && nums[right] == nums[right + 1]) right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-4, -2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(threeSum(a));
    }

}
