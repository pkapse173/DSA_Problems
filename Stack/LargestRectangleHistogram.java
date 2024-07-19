//Problem: Largest Rectangle in Histogram
/*
 * INPUT: heights = [2,1,5,6,2,3]
 *       
 * OUTPUT: 10
 * Explanation:  The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
 */

/*
 * Approach - Using Stack
 * Time Complexity - O(n) - n is storing element in left and right array
 * Space Complexity - O(n) - Space used by stack to store n elements in worst case
 */
import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftSmall[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rightSmall[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightSmall[i] - leftSmall[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

}
    
