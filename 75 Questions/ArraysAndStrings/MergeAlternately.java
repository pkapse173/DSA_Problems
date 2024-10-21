//Problem: Merge Strings Alternately
/*
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
 */
/*
 * Approach 1 - Brute Force with two pointers
 * Time Complexity - O(n + m) n is length of string 1, m is length of string 2
 * Space Complexity - O(n + m) n is length of string 1, m is length of string 2
 */
class solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder mergedString = new StringBuilder();
        int i = 0;
        int j = 0;

        while(i < word1.length() || j < word2.length()){
            if(i < word1.length()){
                mergedString.append(word1.charAt(i));
                i++;
            }
            if(j < word2.length()){
                mergedString.append(word2.charAt(j));
                j++;
            }
        }
       return mergedString.toString();
    }
}

/*
 * Approach 2 - Using pre-allocated memory than StringBuilder
 * Time Complexity - O(n + m) n is length of string 1, m is length of string 2
 * Space Complexity - O(n + m) n is length of string 1, m is length of string 2
 */

 class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int i = 0, j = 0, index = 0;
        int n = word1.length();
        int m = word2.length();
        char[] mergedArray = new char[n + m];

        while(i < n || j < m){
            if(i < n){
                mergedArray[index++] = word1.charAt(i++);
            }
            if(j < m){
                mergedArray[index++] = word2.charAt(j++);
            }
        }
       return new String(mergedArray);
    }
}