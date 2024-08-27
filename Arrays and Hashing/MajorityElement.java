//Problem: Majority Element
/*
 * INPUT: nums = [3,2,3]
 *       
 * OUTPUT: 3
 */
/*
 * Approach 1 - HashMap
 * Time Complexity - O(n) : n is the number of elements in an array
 * Space Complexity - O(n): space used by HashMap to store all the n numbers and it's occurences
 */

import java.util.HashMap;
import java.util.Map;

class MajorityElement {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

/*
 * Approach 2 - HashMap
 * Time Complexity - O(n): n is the number of elements in an array
 * Space Complexity - O(1)
 */

public class MajorityElement {
        public int majorityElement(int[] nums) {
            
            int count = 0;
            int candidate = 0;
    
    
            for(int num : nums){
    
                if(count == 0){
                    candidate = num;
                }
    
                if(num == candidate){
                    count++;
                }else{
                    count--;
                }
            }
        return candidate;
        }
    }
