//Problem: Longest Repeating Character Replacement
/*
 * INPUT: s = "ABAB", k = 2
 *       
 * OUTPUT: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 */

/*
 * Approach - Sliding Window
 * Time Complexity - O(n) - n is length of input string
 * Space Complexity - O(1) - Array used with fix size of 26 char
 * */


package SlidingWindow;

public class LongestRepeatingCharReplace {
        public int characterReplacement(String s, int k) {
            
            int array[] = new int[26];;
            int left = 0;
            int max = 0;
            int maxLength = 0;
    
            for(int right = 0; right < s.length(); right++){
                array[s.charAt(right) - 'A']++;
    
                max = Math.max(max, array[s.charAt(right) - 'A']);
    
                while(right - left + 1 - max > k){
                    array[s.charAt(left) - 'A']--;
                    left++;
                }
    
                maxLength = Math.max(maxLength, right - left + 1);
            }
            return maxLength;
        }
    }
    
