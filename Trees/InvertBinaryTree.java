//Problem: Invert Binary Tree
/*
 * INPUT: root = [4,2,7,1,3,6,9]
 *       
 * OUTPUT: [4,7,2,9,6,3,1]
 */

/*
 * Approach - Traversing Level order keeping queue for storage
 * Time Complexity - O(n) - n is number of nodes in tree
 * Space Complexity - O(n) - Space used by queue
 */
package Trees;

public class InvertBinaryTree {

        public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null){
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }
        }
        return root;
    }
}