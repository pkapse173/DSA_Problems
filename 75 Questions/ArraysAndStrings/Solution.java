//Problem: Greatest Common Divisor of Strings
/*
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
 */

/*
 * Approach 1 - Brute force with substring checking
 * Time Complexity - O((n + m) . log(minLen)) -  where N is the length of str1, M is the length of str2, and minLen is the length of the shorter string.
 * Space Complexity - O(n + m) - where N is the length of str1 and M is the length of str2.
 */

 public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Get the minimum length of the two strings
        int minLen = Math.min(str1.length(), str2.length());

        for (int len = minLen; len > 0; len--) {
  
            if (str1.length() % len == 0 && str2.length() % len == 0) {
                String candidate = str1.substring(0, len);

                if (canDivide(str1, candidate) && canDivide(str2, candidate)) {
                    return candidate;
                }
            }
        }
        return "";
    }

    // Helper function
    private boolean canDivide(String s, String div) {
        int len = div.length();
        int n = s.length() / len;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(div);
        }
        return s.equals(sb.toString());
    }

/*
 * Approach 2 - Using Euclidean Algorithm
 * Time Complexity - O(n + m) n is length of string 1, m is length of string 2 used for concatenation and comparing
 * Space Complexity - O(1) No extra space used
 */


public class gcdOfStrings {
        public String gcdOfStrings(String str1, String str2) {
    
        //Check if string1 and string2 matches or not     
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }
    
        int gcdLength = gcd(str1.length(), str2.length());
    
        return str1.substring(0, gcdLength);
        }
    
        //Calculate gcd length from str1 and str2 length
        private int gcd(int a, int b){
            while(b != 0){
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }
