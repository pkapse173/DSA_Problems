//Problem: Valid Parentheses
/*
 * INPUT: s = "()[]{}"
 *       
 * OUTPUT: true
 */

/*
 * Approach - Using Stack
 * Time Complexity - O(n) - n is number each parenthesis in string
 * Space Complexity - O(n) - Space used by stack to store all parenthesis in worst case
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char ch: s.toCharArray()){
            if(ch == '('){
                 stack.push(')');
            }else if(ch == '{'){
                 stack.push('}');
            }else if(ch == '['){
                 stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != ch)
                return false;
        }
        return stack.isEmpty();
    }
}