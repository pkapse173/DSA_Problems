//Problem: Reverse Vowels of a String
/*
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
 */

/*
 * Approach 1 - Brute force approach
 * Time Complexity - O((n3) -  n is the number elements in an array
 * Space Complexity - O(1) - No extra space used
 */
public class increasingTriplet {
        public boolean increasingTriplet(int[] nums) {
            
           int n = nums.length;
    
           for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    if(nums[i] < nums[j] && nums[j] < nums[k]){
                        return true;
                        }
                    }
                }
            }
        return false;
    }
}

/*
 * Approach 2 - Greedy Approach
 * Time Complexity - O((n) -  n is the number of elements in an array
 * Space Complexity - O(1) - No extra space used
 */

 class Solution {
    public boolean increasingTriplet(int[] nums) {
        
       int first = Integer.MAX_VALUE;
       int second = Integer.MAX_VALUE;

       for(int num : nums){
        if(num <= first){
            first = num;
        }else if(num <= second){
            second = num;
        }else{
            return true;
        }
    }
    return false;
    }
}
