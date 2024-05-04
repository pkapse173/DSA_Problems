//Problem: Search in Rotated Sorted Array
/*
 * INPUT: nums = [4,5,6,7,0,1,2], target = 0
 *       
 * OUTPUT: 4
 * Explanation: 0 exists at index 4
 */

/*
 * Approach - Binary Search Technique
 * Time Complexity - O(log n) - n is number of numers in an array
 * Space Complexity - O(1) - Constant space
 */

public class SearchInRotatedSortedArray {
        public int search(int[] nums, int target) {
    
            int low = 0;
            int high = nums.length - 1;
    
            while(low <= high){
                int mid = low + (high - low)/2;
                if(nums[mid] == target) return mid;
    
                if(nums[low] <= nums[mid]){
                    if(nums[low] <= target && nums[mid] >= target){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }
                else{
                    if(nums[high] >= target && nums[mid] <= target){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }
            } 
                
        return -1;
        }
    }
