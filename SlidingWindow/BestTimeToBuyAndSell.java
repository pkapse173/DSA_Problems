//Problem: Best Time to buy and sell stock
/*
 * Input: prices = [7,1,5,3,6,4]
 *       
 * OUTPUT: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

/*
 * Approach 1 - Brute force
 * Time Complexity - O(n2) - n is number of elements in an array
 * Space Complexity - O(1) - Constant space
 */
public class BestTimeToBuyAndSell {

    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int profit;
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i + 1; j < prices.length; j++){
                profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
           
        }
    }
    

/*
 * Approach 2 - Sliding Window
 * Time Complexity - O(n) - n is number of elements in an array
 * Space Complexity - O(1) - Constant space
 */
public class BestTimeToBuyAndSell {
        public int maxProfit(int[] prices) {
            
        int minPrice = prices[0];
        int maxProfit = 0;
    
        for(int i = 1; i < prices.length; i++){
            int currentPrice = prices[i];
            int potentialProfit = currentPrice - minPrice;
    
            if(potentialProfit > maxProfit){
                maxProfit = potentialProfit;
            }
          
            if(currentPrice < minPrice){
                minPrice = currentPrice;
            }
        }
        return maxProfit;
        }
    }

/*
 * Approach 3 - Kaden's Algorithm
 * Time Complexity - O(n) - n is number of elements in an array
 * Space Complexity - O(1) - Constant space
 */

public class BestTimeToBuyAndSell{
    public int maxProfit(int[] prices) {
        
        int currentProfit = 0;
        int maxProfit = 0;
    
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - prices[i-1];
            currentProfit = Math.max(0, currentProfit + profit);
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
        }
    }
