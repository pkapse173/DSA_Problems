//Problem: Construct Binary Tree from Preorder and Inorder Traversal
/*
 * INPUT: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 *       
 * OUTPUT: [3,9,20,null,null,15,7]
/*
 * Approach - Using HashMap and Iterating over preOrder array
 * Time Complexity - O(n) - n is number elements in preoder array
 * Space Complexity - O(n) - Space used by HashMap to store indexes of inorder elements
 */
package Trees;

import javax.swing.tree.TreeNode;

public class BinaryTreeFromPreAndInorder {
    TreeNode buildTree(int[] preOrder, int[] inOrder){
    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
    for(int i = 0; i < inOrder.length; i++)
        inOrderIndexMap.put(inOrder[i], i);
    
    return splitTree(preOrder, inOrderIndexMap, 0, 0, inOrder.length - 1);
    
}

private TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap, int rootIndex, int left, int right){
    TreeNode root = new TreeNode(preOrder[rootIndex]);

    int mid = inOrderIndexMap.get(preOrder[rootIndex]);
    if (mid > left) 
        root.left = splitTree(preOrder, inOrderIndexMap, rootIndex + 1, left, mid - 1);
    if(mid < right)
        root.right = splitTree(preOrder, inOrderIndexMap, rootIndex + mid - left + 1, mid + 1, right);
    
    return root;
    }
}