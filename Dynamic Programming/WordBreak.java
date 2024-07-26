package Dynamic Programming;

//Problem: Word Break
/*
 * INPUT: s = "leetcode", wordDict = ["leet","code"]
 *       
 * OUTPUT: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */

/*
 * Approach  - Dynamic programming by maintaining DP array
 * Time Complexity - O(n2 . k) 
 * Space Complexity - O(n + m.k) 
 */
public class WordBreak {
        public boolean wordBreak(String s, List<String> wordDict) {
            
            Set<String> wordSet = new HashSet<>(wordDict);
    
            boolean[] dp = new boolean[s.length() + 1];
    
            dp[0] = true;
    
            for(int i = 0; i <= s.length(); i++){
                for(int j = 0; j < i; j++){
                    if(dp[j] && wordSet.contains(s.substring(j, i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
