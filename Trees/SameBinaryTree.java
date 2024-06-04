//Problem: Same Binary Tree
/*
 * INPUT: p = [1,2,3], q = [1,2,3]
 *       
 * OUTPUT: true
 */

/*
 * Approach - By BFS method
 * Time Complexity - O(n) - n is number of nodes in binary tree
 * Space Complexity - O(n) - Space used by queue
 */
package Trees;

public class SameBinaryTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();

                if(node1 == null && node2 == null) continue;
                if(node1 == null || node2 == null) return false;
                if(node1.val!= node2.val) return false;

                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.left);
                queue2.add(node2.right);      
        }
        return true;
    }
}
