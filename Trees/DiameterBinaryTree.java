//Problem: Invert Binary Tree
/*
 * INPUT: root = [1,2,3,4,5]
 *       
 * OUTPUT: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 */

/*
 * Approach - Depth First Search
 * Time Complexity - O(n) - n is number of nodes in binary tree
 * Space Complexity - O(h) - h is height of the tree
 */
package Trees;

public class DiameterBinaryTree {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        diameter(root);
        return max;
    }

    private int diameter(TreeNode root){
        if(root == null) return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);
        max = Math.max(left + right, max);

        return Math.max(left, right) + 1;
    }
}
