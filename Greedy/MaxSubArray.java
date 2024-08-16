//Problem: Maximum SubArray
/*
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */

/*
 * Approach - Using Kadane's Algorithm
 * Time Complexity - O(n) - n is numbe of elements in an array     
 * Space Complexity - O(1)
 */
package Greedy;

public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
    
            int sum = 0;
            int max_sum = nums[0];
    
            for(int i = 0; i < nums.length; i++){
                sum = sum + nums[i];
                if(sum > max_sum){
                    max_sum = sum;
                }
                if(sum < 0){
                    sum = 0;
                }
            }
            return max_sum;
        }
    }
}
