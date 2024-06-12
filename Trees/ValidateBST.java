//Problem: Validate Binary Search Tree
/*
 * INPUT: root = [2,1,3]
 *       
 * OUTPUT: true
 */

/*
 * Approach 1 - Iterative Inorder Traversal
 * Time Complexity - O(n) - n is number of nodes in binary tree
 * Space Complexity - O(h) - height of the tree
 */
package Trees;

 public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;

        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if(prev != null && current.val <= prev.val) return false;
            prev = current;
            current = current.right;
        }
        return true;
    }
 }

/*
 * Approach 2 - Min-Max Range Method
 * Time Complexity - O(n) - n is number of nodes in binary tree
 * Space Complexity - O(h) - h is the height of the tree
 */


import javax.swing.tree.TreeNode;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateBST(TreeNode node, long min, long max){
        if(node == null) return true;
        if(node.val <= min || node.val >= max) return false;
        return validateBST(node.left, min, node.val) && validateBST(node.right, node.val, max);
    }
}
