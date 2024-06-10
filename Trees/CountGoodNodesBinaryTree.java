//Problem: Count Good Nodes in Binary Tree
/*
 * INPUT: root = [3,1,4,3,null,1,5]
 *       
 * OUTPUT: 4
 * Explanation: Nodes in blue are good.
                Root Node (3) is always a good node.
                Node 4 -> (3,4) is the maximum value in the path starting from the root.
                Node 5 -> (3,4,5) is the maximum value in the path
                Node 3 -> (3,1,3) is the maximum value in the path.
 */

/*
 * Approach - Depth-First Search with Recursion
 * Time Complexity - O(n) - n is number of nodes in binary tree
 * Space Complexity - O(h) - h is height of the tree
 */
package Trees;

import javax.swing.tree.TreeNode;

public class CountGoodNodesBinaryTree {
    private int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        calculateGoodNodes(root, root.val);
        return count;
    }
    private void calculateGoodNodes(TreeNode root, int max){

        if(root == null) return;

        if(root.val >= max){
            count++;
            max = root.val;
        }
        calculateGoodNodes(root.left, max);
        calculateGoodNodes(root.right, max);
    }
}
