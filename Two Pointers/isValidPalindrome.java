//Problem: Valid Palindrome
/*
 * INPUT: s = "A man, a plan, a canal: Panama"
 *       
 * OUTPUT: true
 */
/*
 * Approach 1 - Brute force Two pointer apporach with Preprocessing
 * Time Complexity - O(n) - n is length of input string s
 * Space Complexity - O(n) - n length of input string for newString via StringBuilder
 */

 public class isValidPalindrome {
    public boolean isPalindrome(String s) {
        // Converting the string to lowercase and removing non-alphanumeric characters
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String newString = sb.toString();

        int left = 0;
        int right = newString.length() - 1;
        while (left < right) {
            if (newString.charAt(left) != newString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


 /*
 * Approach 2 - Two pointers
 * Time Complexity - O(n) - n is Length of Input String
 * Space Complexity - O(1) - 
 */

 class Solution {
    public boolean isValidPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
        	char left = s.charAt(start);
        	char right = s.charAt(last);
        	if (!Character.isLetterOrDigit(left)) {
        		start++;
        	} else if(!Character.isLetterOrDigit(right)) {
        		last--;
        	} else {
        		if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
        			return false;
        		}
        		start++;
        		last--;
        	}
        }
        return true;
    }
}
