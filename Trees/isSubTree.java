//Problem: Subtree of Another Tree
/*
 * INPUT: root = [3,4,5,1,2], subRoot = [4,1,2]
 *       
 * OUTPUT: true
 */

/*
 * Approach - Recursive Approach
 * Time Complexity - O(n * m) - n is number of nodes in root tree and m is number of nodes in subRoot
 * Space Complexity - O(n) - Recursive stack
 */
package Trees;

import javax.swing.tree.TreeNode;

public class isSubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null) return false;

        if(isSameTree(root, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;

        if(s == null || t == null || s.val != t.val) return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
