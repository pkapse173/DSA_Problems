
//Problem: Koko Eating Bananas
/*
 * Input: piles = [3,6,7,11], h = 8
 *       
 * OUTPUT: 4
 * 
 */

/*
 * Approach - Brute Force
 * Time Complexity - O(n * maxPile) - n is the number of piles and maxPile is the maximum number of bananas in pile 
 * Space Complexity - O(1) - Constant space
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxPile = 0;
        for(int pile : piles){
            maxPile = Math.max(maxPile, pile);
        }

        for(int i = 1; i <= maxPile; i++){
            if(isEatingInTime(piles, i, h)){
                return i;
            }
        }
        return -1;
    }

    private boolean isEatingInTime(int[] piles, int i, int h){
        int hours = 0;
        for(int pile : piles){
            hours += (pile + i - 1) / i;
        }
        return hours <= h;
    }
}