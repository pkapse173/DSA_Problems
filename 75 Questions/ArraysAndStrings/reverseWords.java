//Problem: Reverse Words in a String
/*
Input: s = "the sky is blue"
Output: "blue is sky the"   
 */

/*
 * Approach 1 - Using StringBuilder
 * Time Complexity - O((n) -  n is the length of the input string.
 * Space Complexity - O(n) - due to the space needed to store the split words and the StringBuilder.
 */
public class reverseWords {
        public String reverseWords(String s) {
            
            String[] str = s.split(" +");
            StringBuilder sb = new StringBuilder();
            int n = str.length;
    
            for(int i = n - 1; i >= 0; i--){
                sb.append(str[i]);
                sb.append(" ");
            }
    
            return sb.toString().trim();
        }
}

