
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

/*
 * Approach - Optimized using Binary search
 * Time Complexity - O(n log n) - n is the number of piles and maxPile is the maximum number of bananas in pile 
 * Space Complexity - O(1) - Constant space
 */

 class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;

        int maxSpeed = 0;
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }
        // Binary Search
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            if (canEatInTime(piles, h, mid))
                maxSpeed = mid;
            else
                minSpeed = mid + 1;
        }
        return minSpeed;
    }

    private boolean canEatInTime(int[] piles, int h, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / speed);
        }
        return hours <= h;
    }
}