//Problem: Binary Tree Level Order Traversal
/*
 * INPUT: root = [3,9,20,null,null,15,7]
 *       
 * OUTPUT: [[3],[9,20],[15,7]]
/*
 * Approach 1 - Tarversing each node level wise using queue
 * Time Complexity - O(n) - n is number of nodes in tree
 * Space Complexity - O(n) - space used by queue and List
 */
package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class BinaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> innerResult = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                innerResult.add(node.val);
            
                if(node.left != null) 
                queue.add(node.left);
            
                if(node.right != null)
                queue.add(node.right); 

            }
            result.add(innerResult);
        }
        return result;
    }
}