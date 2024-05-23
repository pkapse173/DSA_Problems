//Problem: Best Time to buy and sell stock
/*
 * Input: nums = [1,3,4,2,2]
 *       
 * OUTPUT: 2

/*
 * Approach - Slow and Fast pointer
 * Time Complexity - O(n) - n is number of elements in an array
 * Space Complexity - O(1) - Constant space
 */
package LinkedList;

    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            do{
                slow = nums[slow];
                fast = nums[nums[fast]];
            }while(slow != fast);
    
            slow = 0;
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
