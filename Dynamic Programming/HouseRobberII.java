package Dynamic Programming;

//Problem: House Robber
/*
 * INPUT: nums = [2,3,2]
 *       
 * OUTPUT: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), 
 * because they are adjacent houses.

/*
 * Approach - Dynamic programming by maintaining DP array
 * Time Complexity - O(n) - n is the total number of numbers in an array that we are iterating
 * Space Complexity - O(n) - Space used by dp array to fill the max profit
 */
public class HouseRobberII {
        public int rob(int[] nums) {
    
            int n = nums.length;
            //base case
            if(n == 0 || nums.length == 0) return 0;
            if(n < 2) return nums[0];
    
            int firstHouse[] = new int[n-1];
            int secondHouse[] = new int[n-1];
    
            for(int i = 0; i < n-1; i++){
                firstHouse[i] = nums[i];
                secondHouse[i] = nums[i+1];
            }
    
            //Gettting two values
            int houseI = robTheHouse(firstHouse);
            int houseII = robTheHouse(secondHouse);
    
            return Math.max(houseI, houseII);
        }   
            //Solving the normal robber house function
            private int robTheHouse(int nums[]){
            
            if(nums.length < 2) return nums[0];
            
            int [] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
    
            for(int i = 2; i < nums.length; i++){
                dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
            }
            return dp[nums.length-1];
        }
    }
