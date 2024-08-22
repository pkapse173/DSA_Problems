//Problem: Baseball Game
/*
Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.
 */

/*
 * Approach  - Using Stack to access all elements
 * Time Complexity - O(n) - n is the number of operations in ops    
 * Space Complexity - O(n) - for storing valid scores in the stack
 */

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String op : operations){
            if(op.equals("+")){
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            }else if(op.equals("D")){
                stack.push(2 * stack.peek());
            }else if(op.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.valueOf(op));
            }
        }

        int totalScore = 0;
        for(int score : stack){
            totalScore += score;
        }
    return totalScore;
            
        }
}
