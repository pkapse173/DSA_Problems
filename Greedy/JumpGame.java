//Problem: Jump Game
/*
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */

/*
 * Approach 1 - Recursion
 * Time Complexity - O(2^n) - n is number of elements in an array     
 * Space Complexity - O(n) - due to recursive stack
*/

package Greedy;
class Solution {
    public boolean canJump(int[] nums) {
        return canReachDestination(nums, 0);
    }

    private boolean canReachDestination(int[] nums, int currentIndex){
        int maxIndex = nums.length - 1;
        if(currentIndex >= maxIndex){
            return true;
        }
        int maxJump = nums[currentIndex];
        for(int jump = 1; jump <= maxJump; jump++){
            if(canReachDestination(nums, jump + currentIndex)){
                return true;
            }
        }
        return false;
    }
}

/*
 * Approach 2 - Greedy Approach
 * Time Complexity - O(n) - n is number of elements in an array     
 * Space Complexity - O(1) - No Extra Space
*/
public class JumpGame {
        public boolean canJump(int[] nums) {
            int farthest = 0;
            for (int i = 0; i < nums.length; i++) {
    
                if (i > farthest) {
                    return false;
                }
         
                farthest = Math.max(farthest, i + nums[i]);
            }
            return true;
        }
    }
