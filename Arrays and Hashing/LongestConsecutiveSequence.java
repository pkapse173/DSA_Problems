//Problem: Longest Consecutive Sequence
/*
 * INPUT: nums = [100, 4, 200, 1, 3, 2]
 *       
 * OUTPUT: 4
 */
/*
 * Approach 1 - By Sorting an Array
 * Time Complexity - O(nlogn)
 * Space Complexity - O(1)
 */


import java.util.Arrays;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        //Sorting array in ascending order
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        int temp = 1;

        //Base Case
        if(n == 0) return 0;
        if(n ==1) return 1;

        //Main Logic
        for(int i = 0; i < n-1; i++){
            if(nums[i] == (nums[i + 1] - 1)){
                temp++;
                count = Math.max(count, temp);
            }else if(nums[i] == (nums[i+1])){
                count = Math.max(count, temp);                  
            }else{
                temp = 1;
                count = Math.max(count, temp);
            }
        }
        return count;
    }
}

/*
 * Approach 2 - Using HashSet
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */

 class Solution {
    public int longestConsecutive(int[] nums) {
        
     HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestCount = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) { 
                int currentNum = num;
                int currentCount = 1;

                while (numSet.contains(currentNum + 1)) { 
                    currentNum++;
                    currentCount++;
                }

                longestCount = Math.max(longestCount, currentCount); 
            }
        }

        return longestCount;
    }
}