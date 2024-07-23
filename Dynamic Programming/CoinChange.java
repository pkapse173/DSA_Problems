//Problem: Coin Change
/*
 * INPUT: coins = [1,2,5], amount = 11
 *       
 * OUTPUT: 3
 * Explanation: 11 = 5 + 5 + 1


/*
 * Approach 1 - Dynamic programming by maintaining DP array
 * Time Complexity - O(n * m) - m is amount for outer loop and n is for inner loop of coins
 * Space Complexity - O(m) - DP array to store m amount 
 */

package Dynamic Programming;

public class CoinChange {
        public int coinChange(int[] coins, int amount) {
            
            if(amount < 1) return 0;
    
            //Creating DP array
            int[] dp = new int[amount + 1];
    
            for(int i = 1; i <= amount; i++){
                dp[i] = Integer.MAX_VALUE;
    
                for(int coin : coins)
                    if(coin <= i && dp[i - coin] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            if(dp[amount] == Integer.MAX_VALUE) return -1;
            return dp[amount];
        }
}
