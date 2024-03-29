//Problem: Two Sum II Input Array is sorted
/*
 * INPUT: numbers =[2,7,11,15], target = 9
 *       
 * OUTPUT: [1,2]
 */
/*
 * Approach 1 - Brute force apporach with two for loops
 * Time Complexity - O(n2) - n is length of input array
 * Space Complexity - O(1) - n space used by list does not scale with size if the input array
 */

import java.util.ArrayList;
import java.util.List;

public class TwoSum_II {
        public int[] twoSum(int[] numbers, int target) {
        
        int n = numbers.length;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(numbers[j] + numbers[i] == target){
                    result.add(i+1);
                    result.add(j+1);
                    return result.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }
        return new int[0];
    }
}


/*
 * Approach 2 - Using HashMap by storing number and its index
 * Time Complexity - O(n) - n is length of input array
 * Space Complexity - O(n) - Hashmap for storing all numbers
 */

 public class TwoSum_II {
public int[] twoSum(int[] numbers, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < numbers.length; i++) {
        int complement = target - numbers[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement) + 1, i + 1};
        }
        map.put(numbers[i], i);
    }
    //if no solution not found
    return new int[0]; 
    }
 }

/*
 * Approach 3 - Optimized Two pointer approach
 * Time Complexity - O(n) - n is number of elements in an array
 * Space Complexity - O(1) - space used by list does not scale with size if the input array
 */

public class TwoSum_II {
        public int[] twoSum(int[] numbers, int target) {
    
          int i = 0;  
          int j = numbers.length - 1;
          List<Integer> result = new ArrayList<>();
          //Checking will we will not get target
          while(numbers[i] + numbers[j] != target){
            if(numbers[i] + numbers[j] > target){
                j--;
            }else{
                i++;
            }
          }
          result.add(i+1);
          result.add(j+1);
          return result.stream().mapToInt(Integer::intValue).toArray();
    
        }
    }
    

