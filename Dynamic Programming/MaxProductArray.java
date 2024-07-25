//Problem: Maximum Product SubArray
/*
 * INPUT: nums = [2,3,-2,4]
 *       
 * OUTPUT: 6
 * Explanation: [2,3] has the largest product 6.
 */

/*
 * Approach - Using DP array to maintain max and min product
 * Time Complexity - O(n) - n is the number of elements in an given array
 * Space Complexity - O(1) - No extra space 
 */

package Dynamic Programming;

public class MaxProductArray {
        public int maxProduct(int[] nums) {
        
            int max = nums[0], min = nums[0], ans = nums[0];
            int n = nums.length;
            
            for (int i = 1; i < n; i++) {
                // Swapping min and max
                if (nums[i] < 0){
                    int temp = max;
                    max = min;
                    min = temp;
                }   
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
    
                ans = Math.max(ans, max);
            }
            return ans;
        }
    }

