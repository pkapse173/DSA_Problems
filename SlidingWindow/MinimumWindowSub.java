//Problem: Minimum Window Substring
/*
 * INPUT: s = "ADOBECODEBANC", t = "ABC"
 *       
 * OUTPUT: "BANC"
 * Explanation:  The minimum window substring "BANC" 
 * includes 'A', 'B', and 'C' from string t.
 */

/*
 * Approach - Sliding Window
 * Time Complexity - O(n) - n is length of the input string s.
 * Space Complexity - O(1) - Size of the map array is constant (128)
 * */


package SlidingWindow;

public class MinimumWindowSub {

        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                    s.length() < t.length()) {
                return new String();
            }
            int[] map = new int[128];
            int count = t.length();
            int left = 0, right = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        
            for (char c : t.toCharArray()) {
                map[c]++;
            }
    
            char[] chS = s.toCharArray();
    
            while (right < chS.length) {
                if (map[chS[right++]]-- > 0) {
                    count--;
                }
                while (count == 0) {
                    if (right - left < minLen) {
                        startIndex = left;
                        minLen = right - left;
                    }
                    if (map[chS[left++]]++ == 0) {
                        count++;
                    }
                }
            }
            return minLen == Integer.MAX_VALUE ? new String() :
                    new String(chS, startIndex, minLen);
        }
    }
