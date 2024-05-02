//Problem: Find Minimum in Rotated Sorted Array
/*
 * Input: nums = [3,4,5,1,2]
 *       
 * OUTPUT: 1
 * 
 */

/*
 * Approach 1 - Brute Force
 * Time Complexity - O(n) - n is the number elements in an array
 * Space Complexity - O(1) - Constant space
 */

public class findMin {
        public int findMin(int[] nums) {
            int min = nums[0];
            for(int num : nums){
                min = Math.min(num, min);
            }
            return min;
        }
    }

/*
 * Approach 2 - By using sort method
 * Time Complexity - O(n log n) - n is the number elements in an array
 * Space Complexity - O(log n) - Space used by sorting algo recursive call and stack manipulation
 */
class findMin {
        public int findMin(int[] nums) {
            Arrays.sort(nums);
            return nums[0];
        }
    }

/*
 * Approach 3 - Binary Search
 * Time Complexity - O(log n) - n is the number elements in an array
 * Space Complexity - O(1) - Constant Space 
 */
    
 class findMin {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid = low + (high - low)/2;

            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high = mid;
            }

        }
        return nums[high];
    }
}