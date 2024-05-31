//Problem: Maximum Depth of Binary tree
/*
 * INPUT: root = [3,9,20,null,null,15,7]
 *       
 * OUTPUT: 3
 */

/*
 * Approach - Traversing each node level by level
 * Time Complexity - O(n) - n is number of nodes in binary tree
 * Space Complexity - O(n) - Space used by queue
 */
package Trees;

public class MaximumDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
            TreeNode node = queue.poll();

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
            count++;
    }
    return count;
    }
}

