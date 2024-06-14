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