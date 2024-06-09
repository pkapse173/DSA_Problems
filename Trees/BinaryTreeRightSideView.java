//Problem: Binary Tree Right Side View
/*
 * INPUT: root = [1,2,3,null,5,null,4]
 *       
 * OUTPUT: [1,3,4]
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

public class BinaryTreeRightSideView {

        class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if(root == null){
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);

                        if(i == size - 1){
                        result.add(node.val);
                        }
                    }
                }
            return result;
        }
    }
    
}
