//Problem: Kth Smallest Element in a BST
/*
 * INPUT: root = [3,1,4,null,2], k = 1
 *       
 * OUTPUT: 1
 */

/*
 * Approach 1 - Recursive DFS Approach
 * Time Complexity - O(n) - n is number of nodes binary tree
 * Space Complexity - O(n) - max depth of the recursion stack is equal to height H of tree
 */
package Trees;

import javax.swing.tree.TreeNode;

public class KthSmallestElement {
    private int count = 0;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrderDFS(root, k);
        return result;
    }
    private void inOrderDFS(TreeNode root, int k){
        if(root == null) return;

            inOrderDFS(root.left, k);

            count++;

            if(count == k){
                result = root.val;
                return;
            }
            
            inOrderDFS(root.right, k);
    }
}

//Problem: Kth Smallest Element in a BST
/*
 * INPUT: root = [3,1,4,null,2], k = 1
 *       
 * OUTPUT: 1
 */

/*
 * Approach - Recursion using Stack
 * Time Complexity - O(n) - n is number of nodes in binary tree 
 * Space Complexity - O(n) - recursive stack
 */

public class KthSmallestElement {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode current = root;

        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            count++;
            if(count == k){
                return current.val;
            }

            current = current.right;
        }
    return -1;
    }
}
