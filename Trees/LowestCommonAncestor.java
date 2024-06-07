//Problem: Lowest Common Ancestor of a Binary Tree
/*
 * INPUT: root = root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *       
 * OUTPUT: 3
 */

/*
 * Approach - Recursive Approach
 * Time Complexity - O(n) - n is the number of nodes in the tree
 * Space Complexity - O(h) - Height of the tree
 */
package Trees;

import javax.swing.tree.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return root;
        }
    }
}
