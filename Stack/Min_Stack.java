//Problem: Min Stack
/*
 * INPUT: = ["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

 *       
 * OUTPUT: [null,null,null,null,-3,null,0,-2]
 */

/*
 * Approach - Using Stack
 * Time Complexity - O(1)     
 * Space Complexity - O(1) 
 */

import java.util.Stack;

    class MinStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int val) {
        if(stack2.isEmpty() || val <= stack2.peek()){
            stack2.push(val);
        }
        stack1.push(val);
    }
    
    public void pop() {
        if (!stack1.isEmpty()) {
            int popped = stack1.pop();
            if (popped == stack2.peek()) {
                stack2.pop();
            }
        }
    }
    
    public int top() {
        if(!stack1.isEmpty()){
            return stack1.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

