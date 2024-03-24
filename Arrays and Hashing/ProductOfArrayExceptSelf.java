//Problem: Product of Array Except Self
/*
 * INPUT: nums = [1,2,3,4]
 *       
 * OUTPUT: [24,12,8,6]
 */
/*
 * Approach 1 - Brute force approach
 * Time Complexity - O(n2) - n is length of input array
 * Space Complexity - O(n) - n is length of input array
 */


public class ProductOfArrayExceptSelf {
        public int[] productExceptSelf(int[] nums) {
            
            int n = nums.length;
            int[] ans = new int[n];
            
            for(int i = 0; i < n; i++){
                int product = 1;
                for(int j = 0; j < n; j++){
                    if(i == j){
                        continue;
                    }
                    product = product * nums[j]; 
                    ans[i] = product; //storing into answer
                }
            }
            return ans;
        }
    }
    
/*
 * Approach 2 - Prefix multiplication
 * Time Complexity - O(n) - n is the length of input array
 * Space Complexity - O(n) - using the different arrays of size n
 */

 class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
       int n = nums.length; 
       int leftPro[] = new int[n];
       int rightPro[] = new int[n];
       int result[] = new int[n];

       //Calclulating the left-product
       leftPro[0] = 1;
       for(int i = 1; i < n; i++){
            leftPro[i] = leftPro[i-1] * nums[i-1];
       }
       //calculating the right product
       rightPro[n-1] = 1;
       for(int i = n-2; i >= 0; i--){
            rightPro[i] = rightPro[i+1] * nums[i+1];
       }
       //calculating the actual output array
       for(int i = 0; i < n; i++){
            result[i] = leftPro[i] * rightPro[i];
       }

       return result;
    }
}