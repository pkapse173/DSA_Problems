//Problem: Same Binary Tree
/*
 * INPUT: root = [1,null,3,2,4,null,5,6]
 *       
 * OUTPUT: [5,6,3,2,4,1]
 */

/*
 * Approach - By traversing DFS
 * Time Complexity - O(n) - n is number of nodes in tree
 * Space Complexity - O(n) - Space used n nodes to store in list
 */

package Trees;

public class N_AryTreePostOrder {
        public List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            dfs(root, list);
            return list;
        }
    
        public void dfs(Node root, List<Integer> list){
            if(root == null) return;
            for(Node child : root.children){
                dfs(child, list);
            }
            list.add(root.val);
        }
    }

