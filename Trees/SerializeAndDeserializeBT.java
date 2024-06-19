//Problem: Serialize and Deserailize Binary Tree
/*
 * INPUT: root = [1,2,3,null,null,4,5]
 *       
 * OUTPUT: [1,2,3,null,null,4,5]
 */

/*
 * Approach - By Level Order Traversal
 * Time Complexity - O(n) - n is number of nodes in binary tree
 * Space Complexity - O(n) - Space used by queue
 */
package Trees;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class SerializeAndDeserializeBT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                result.append("null ");
                continue;
            }

            result.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
    return result.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if(data == null || data.isEmpty()) return null;
    Queue<TreeNode> queue = new LinkedList<>();
    String[] values = data.split(" ");
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    queue.add(root);
    for(int i = 1; i < values.length; i++){
        TreeNode parent = queue.poll();
        if(!values[i].equals("null")){
            TreeNode left = new TreeNode(Integer.parseInt(values[i]));
            parent.left = left;
            queue.add(left);
        }
        if(!values[++i].equals("null")){
            TreeNode right = new TreeNode(Integer.parseInt(values[i]));
            parent.right = right;
            queue.add(right);
        }
    }   
    return root;
    }
}
