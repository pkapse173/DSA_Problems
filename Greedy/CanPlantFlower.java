//Problem: Can Plant Flower
/*
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
 */

/*
 * Approach  - Greedy Approach
 * Time Complexity - O(n) - n is number of elements in an array     
 * Space Complexity - O(1) - No extra space
*/
package Greedy;

public class CanPlantFlower {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            
            if(n == 0) return true;
    
            int k = flowerbed.length;
            int count = 0;
    
            for(int i = 0; i < k; i++){
                if(flowerbed[i] == 0 
                && (i == 0 || flowerbed[i-1] == 0)
                && (i == k - 1 || flowerbed[i+1] == 0)){
    
                    flowerbed[i] = 1;
                    count++;
                }
                if(count >= n) return true;
    
            }
    
            return false;
        }
    }

