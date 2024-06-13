//Problem: Balanced Binary Tree
/*
 * INPUT: root = [1,2,3]
 *       
 * OUTPUT: 6
/*
 * Approach  - DFS traversal with recursion
 * Time Complexity - O(n) - n is number of nodes in tree
 * Space Complexity - O(h) - h is the height if the binary tree
 */
package Trees;

import javax.swing.tree.TreeNode;

public class BinaryTreeMaxPathSum {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        checkMaxPathSum(root);
        return maxSum;
    }

    private int checkMaxPathSum(TreeNode node){
        if(node == null) return 0;

        int leftNode = Math.max(checkMaxPathSum(node.left), 0);
        int rightNode = Math.max(checkMaxPathSum(node.right), 0);

        int currentMax = leftNode + rightNode + node.val;

        maxSum = Math.max(maxSum, currentMax);

        return node.val + Math.max(leftNode, rightNode);
    }
}