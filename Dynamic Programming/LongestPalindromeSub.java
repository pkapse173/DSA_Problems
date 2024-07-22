package Dynamic Programming;
//Problem: Largest Palindrome Substring
/*
 * INPUT: s = "babad"
 *       
 * OUTPUT: "bab"
 * Explanation: "aba" is also a valid answer.
 */

/*
 * Approach 1 - Expand around center
 * Time Complexity - O(n2) 
 * Space Complexity - O(n) 
 */

public class LongestPalindromeSub {
        public String longestPalindrome(String s) {
            
        if(s.length() <=1 ) return s;
    
        String LPS = "";
    
        for(int i = 1; i < s.length(); i++){
    
            //for odd length of string
            int low = i;
            int high = i;
    
            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
    
                if(low == -1 || high == s.length()) break;
            }
    
            String palindrome = s.substring(low+1, high);
            if(palindrome.length() > LPS.length()){
                LPS = palindrome;
            }
    
            //for even length of string
            low = i - 1;
            high = i;
    
            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
    
                if(low == -1 || high == s.length()) break;
            }
                palindrome = s.substring(low+1, high);
                if(palindrome.length() > LPS.length()){
                    LPS = palindrome;
                }
            }
            return LPS;
        } 
    }

/*
 * Approach 1 - Dynamic Programming
 * Time Complexity - O(n2) 
 * Space Complexity - O(n2) 
 */
    class LongestPalindromeSub {
        public String longestPalindrome(String s) {
        
        if(s.length() <= 1){
            return s;
        }
    
        int maxLen = 1;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
    
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
            for(int j = 0; j < i; j++){
                if(s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])){
                    dp[j][i] = true;
                    if(i-j+1 > maxLen){
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
        }
    }


