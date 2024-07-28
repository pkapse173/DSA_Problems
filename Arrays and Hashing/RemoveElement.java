//Problem: Remove Element
/*
 * INPUT: nums = [3,2,2,3], val = 3
 *       
 * OUTPUT: 2, nums = [2,2,_,_]
 */
/*
 * Approach: Iterating through array
 * Time Complexity - O(n) - n is length of input array
 * Space Complexity - O(1) - no extra space
 */

public class RemoveElement {

        public int removeElement(int[] nums, int val) {
            
        int n = 0;
    
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
        }
    }
