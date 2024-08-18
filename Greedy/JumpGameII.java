//Problem: Jump Game II
/*
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. 
Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */

/*
 * Approach 1 - Greedy Approach
 * Time Complexity - O(n) - n is the total number of elements in an array    
 * Space Complexity - O(1) - No Extra Space
*/

package Greedy;

public class JumpGameII {
        public int jump(int[] nums) {
            if(nums.length == 1) return 0;
            int destination = nums.length - 1;
            int totalJump = 0;
    
            int coverage = 0;
            int lastJumpIndex = 0;
    
            for(int i = 0; i < nums.length; i++){
                coverage = Math.max(coverage, i + nums[i]);
    
                if(i == lastJumpIndex){
                    lastJumpIndex = coverage;
                    totalJump++;
    
                    if(coverage >= destination) return totalJump;
                }
            }
            return totalJump;
        }
    }


/*
 * Approach 2 - Recursion
 * Time Complexity - O(2^n) - n is the total number of elements in an array    
 * Space Complexity - O(n) - Recursion stack 
*/
    class Solution {
        public static int jump(int[] nums) {
           return jumpHelper(nums, 0);
       }
   
       private static int jumpHelper(int[] nums, int position) {
   
           if (position >= nums.length - 1) {
               return 0;
           }
   
           int maxReach = position + nums[position];
           int minJumps = Integer.MAX_VALUE;
   
           for (int i = position + 1; i <= maxReach && i < nums.length; i++) {
               int jumps = jumpHelper(nums, i);
               if (jumps != Integer.MAX_VALUE) {
                   minJumps = Math.min(minJumps, 1 + jumps);
               }
           }
   
           return minJumps;
       }
   }
