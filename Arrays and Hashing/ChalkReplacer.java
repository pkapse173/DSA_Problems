//Problem: Find the Student that Will Replace the Chalk
/*
 * Input: chalk = [5,1,5], k = 22
 * Output: 0
 * Explanation: The students go in turns as follows:
- Student number 0 uses 5 chalk, so k = 17.
- Student number 1 uses 1 chalk, so k = 16.
- Student number 2 uses 5 chalk, so k = 11.
- Student number 0 uses 5 chalk, so k = 6.
- Student number 1 uses 1 chalk, so k = 5.
- Student number 2 uses 5 chalk, so k = 0.
Student number 0 does not have enough chalk, so they will have to replace it.
 */
/*
 * Approach 1 - Visiting array multiple times until k becomes 0
 * Time Complexity - O(n * (k/s)) n is length of chalk, k is the initial number of chalk pieces, and s is the sum of all elements in chalk array
 * Space Complexity - O(1)
 */
public class ChalkReplacer {
        public int chalkReplacer(int[] chalk, int k) {
            
            if(chalk.length == 0) return -1;
    
            while(k >= 0){
                for(int i = 0; i < chalk.length; i++){
                    if(chalk[i] <= k){
                        k = k - chalk[i];
                    }else{
                        return i;
                    }
                }
            }
            return -1;
        }
}

    /*
 * Approach 2 - Modulo operation
 * Time Complexity - O(n) n is the number of chalk elements in an array
 * Space Complexity - O(1)
 */

    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk = 0;
        for (int amount : chalk) {
            totalChalk += amount;
        }
        k %= totalChalk;
        
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        
        return -1; 
}