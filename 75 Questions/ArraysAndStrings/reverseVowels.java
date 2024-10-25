//Problem: Reverse Vowels of a String
/*
Input: s = "IceCreAm"
Output: "AceCreIm"
 */

/*
 * Approach 1 - Two pointer approach
 * Time Complexity - O((n) -  n is the number of character in String s
 * Space Complexity - O(n) - space is used by result array to store String s
 */
public class reverseVowels {
        public String reverseVowels(String s) {
            
            int n = s.length();
            char[] result = s.toCharArray();
            int left = 0;
            int right = n - 1;
    
            while(left < right){
    
                while(left < right && !isVowel(result[left])){
                    left++;
                }
    
                while(left < right && !isVowel(result[right])){
                    right--;
                }
    
                char temp = result[left];
                result[left] = result[right];
                result[right] = temp;
    
                left++;
                right--;
            }
            return new String(result);
        }
    
            public static boolean isVowel(char ch){
                ch = Character.toLowerCase(ch);
                return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
            }
}
