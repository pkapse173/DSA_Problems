//Problem: Permutation in String
/*
 * INPUT: s1 = "ab", s2 = "eidbaooo"
 *       
 * OUTPUT: true
 * Explanation:  s2 contains one permutation of s1 ("ba").
 */

/*
 * Approach - Sliding Window
 * Time Complexity - O(n) - n is max length of s2 String
 * Space Complexity - O(1) - HashMap are using fixed 26 char size
 * */



package SlidingWindow;

public class PermutationInString {

        public boolean checkInclusion(String s1, String s2) {
         int[] s1Map = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                s1Map[s1.charAt(i) - 'a']++; 
            }
    
            int[] s2Map = new int[26];
            for (int i = 0; i < s2.length(); i++) {
                if (i < s1.length()) {
                    s2Map[s2.charAt(i) - 'a']++; 
                } else {
                    s2Map[s2.charAt(i) - 'a']++; 
                    s2Map[s2.charAt(i - s1.length()) - 'a']--; 
                }
                if (match(s1Map, s2Map)) { 
                    return true;
                }
            }
            return false;
        }
    
        static boolean match(int[] s1Map, int[] s2Map) {
            for (int i = 0; i < 26; i++) {
                if (s1Map[i] != s2Map[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    
