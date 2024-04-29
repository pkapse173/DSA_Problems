//Problem: Evaluate Reverse Polish Notation
/*
 * INPUT: nums = [-1,0,3,5,9,12], target = 9
 *       
 * OUTPUT: 4
 * Explanation: 9 exists in nums and its index is 4
 */

/*
 * Approach - Binary Search Technique
 * Time Complexity - O(log n) - n is number of numers in an array
 * Space Complexity - O(1) - Constant space
 */

class Solution {
    public int search(int[] nums, int target) {
       
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else
                high = mid - 1;
            }
        return -1;
    }
}