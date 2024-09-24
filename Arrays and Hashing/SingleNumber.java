//Problem: Single Number
/*
 * Input: nums = [2,2,1]
 * Output: 1
/*
 * Approach 1 - Sort the array and compare consecutive numbers
 * Time Complexity - O(n log n)) n is the number of elements in an array
 * Space Complexity - O(1)
 */

import java.util.HashMap;
import java.util.Map;



class SingleNumber {
    public int singleNumber(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n-1; i += 2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[n-1];
    }
}

/*
 * Approach 2 - Using HashMap with key value pair
 * Time Complexity - O(n)) n is the number of elements in an array
 * Space Complexity - O(n) Space used by HashMap
 */
class SingleNumber {
    public int singleNumber(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
    return -1;
    }
}

/*
 * Approach 3 - Using XOR operation
 * Time Complexity - O(n) n is the number of elements in an array
 * Space Complexity - O(1) 
 */
class SingleNumber {
    public int singleNumber(int[] nums) {
        
        int single = 0;
        for(int i = 0; i < nums.length; i++){
            single ^= nums[i];
        }
        return single;
    }
}
