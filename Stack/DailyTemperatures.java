//Problem: Daily Temperatures
/*
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
 */

/*
 * Approach 1 - Using Brute force(Two loops)
 * Time Complexity - O(n2) - n is numbe of elements in an array     
 * Space Complexity - O(n) - n is number of elements used to store in result
 */

public class DailyTemperatures {
        public int[] dailyTemperatures(int[] temperatures) {
            
            int n = temperatures.length;
            int[] result = new int[n];
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    if(temperatures[i] < temperatures[j]){
                        result[i] = j - i;
                        break;
                    }
                }
            }
            return result;
        }
    }
    
/*     
* Approach 2 - Using stack
* Time Complexity - O(n) - n is number of elements in temp array    
* Space Complexity - O(n) - n is number of elements used to store in stack
*/
class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i = n-1; i >= 0; i--){
            
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }
}
   