//Problem: Longest Substring Without Repeating Characters
/*
 * INPUT: s = "abcabcbb"
 *       
 * OUTPUT: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

/*
 * Approach - Sliding Window
 * Time Complexity - O(n) - n number character in a string
 * Space Complexity - O(k) - k is space used by Set
 * */


public class LengthOfLongestSubstring {

            
            Set<Character>set=new HashSet<>();
            int maxLength=0;
            int left=0;
            for(int right=0;right<s.length();right++){
               
                if(!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    maxLength=Math.max(maxLength,right-left+1);
                    
                }else{
                    while(s.charAt(left)!=s.charAt(right)){
                        set.remove(s.charAt(left));
                        left++;
                    }
                    set.remove(s.charAt(left));left++;
                    set.add(s.charAt(right));
                }
                
            }
            return maxLength;
        }
}
