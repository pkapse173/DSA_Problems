package Dynamic Programming;

//Problem: House Robber
/*
 * INPUT: nums = [1,2,3,1]
 *       
 * OUTPUT: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.


/*
 * Approach 1 - Dynamic programming by maintaining DP array
 * Time Complexity - O(n) - n is the total number of numbers in an array that we are iterating
 * Space Complexity - O(n) - Space used by dp array to fill the max profit
 */

public class HouseRobber {
        public int rob(int[] nums) {
            
            int n = nums.length;
            if(n == 0 || nums.length == 0) return 0;
            if(n < 2) return nums[0];
    
            int [] dp = new int [n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
    
            for(int i = 2; i < n; i++){
                dp[i] = Math.max(dp[i-1], (nums[i] + dp[i-2]));
            }
            return dp[n-1];
        }
    }

    /*
 * Approach 1 - Dynamic programming by maintaining DP array
 * Time Complexity - O(n) - n is the total number of numbers in an array that we are iterating
 * Space Complexity - O(1) 
 */

    class HouseRobber {
        public int rob(int[] nums) {
            
            int n = nums.length;
            if(n == 0 || nums.length == 0) return 0;
            if(n < 2) return nums[0];
    
            int first = nums[0];
            int second = Math.max(nums[0], nums[1]);
    
            for(int i = 2; i < n; i++){
                int temp = second;
                second = Math.max(nums[i] + first, second);
                first = temp;
            }
            return second;
        }
    }