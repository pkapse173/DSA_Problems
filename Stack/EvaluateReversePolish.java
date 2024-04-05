//Problem: Evaluate Reverse Polish Notation
/*
 * INPUT: tokens = ["2","1","+","3","*"]
 *       
 * OUTPUT: 9
 * Explanation: ((2 + 1) * 3) = 9
 */

/*
 * Approach - Using Stack
 * Time Complexity - O(n) - n is number strings in tokens
 * Space Complexity - O(n) - Space used by stack to store all notations
 */


import java.util.Stack;

public class EvaluateReversePolish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        String operators = "+-*/";

        for (String token : tokens) {
            if (operators.contains(token)) {
                
                int d2 = st.pop();
                int d1 = st.pop();
                int ans = 0;

                switch (token) {
                    case "+":
                        ans = d1 + d2;
                        break;
                    case "-":
                        ans = d1 - d2;
                        break;
                    case "*":
                        ans = d1 * d2;
                        break;
                    case "/":
                        ans = d1 / d2;
                        break;
                }
                st.push(ans);
            } else {
                //Pushing number to stack
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop(); //Final answer
    }
}
