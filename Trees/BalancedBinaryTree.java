//Problem: Balanced Binary Tree
/*
 * INPUT: root = [3,9,20,null,null,15,7]
 *       
 * OUTPUT: true
/*
 * Approach 1 - Using Top Down approach - BFS
 * Time Complexity - O(n2) - n is number of nodes in tree
 * Space Complexity - O(n) - use of queue in BFS Traversal
 */
package Trees;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        
        if(root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            int left = height(node.left);
            int right = height(node.right);

            if(Math.abs(left - right) > 1) return false;

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return true;
    }

    private int height(TreeNode root){
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            height++; 
        }
        return height;
    }
}

/*
 * Approach 2 - Using bottom up approach - DFS
 * Time Complexity - O(n) - n is number of nodes in tree
 * Space Complexity - O(n) - height of the tree
 */

class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
        }
    
    private int dfs(TreeNode root){
        if(root == null) return 0;

        int leftHeight = dfs(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = dfs(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight)+1;
    }
}