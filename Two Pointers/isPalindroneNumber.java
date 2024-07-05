//Problem: isPalindrome Number
/*
 * INPUT: x = 121
 *       
 * OUTPUT: true
 */

/*
 * Approach 1 - Two pointer approach
 * Time Complexity - O(n) - n is number of digits in x
 * Space Complexity - O(n) - Space taken by String to store n number of digits
 */
public class isPalindroneNumber {
        public boolean isPalindrome(int x) {
    
        String str = Integer.toString(x);
        int left = 0;
        int right = str.length() - 1;
    
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
        }
    }

    /*
 * Approach 2 - Reverse the number
 * Time Complexity - O(n) - n is number of digits in x
 * Space Complexity - O(1) - No extra space
 */

    class isPalindroneNumber {
        public boolean isPalindrome(int x) {
        
        int number = x;
        int reverse = 0;
        while(x > 0){
            reverse = x%10 + reverse*10;
            x = x/10;
        }
        return reverse == number ? true : false;
        }
    }
