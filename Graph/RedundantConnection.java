package Graph;

public class RedundantConnection {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int[] parent = new int[edges.length + 1];
            
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            
            for (int[] edge : edges) {
                int node1 = edge[0];
                int node2 = edge[1];
                
                int root1 = find(parent, node1);
                int root2 = find(parent, node2);
                
                if (root1 == root2) {
                    return edge;
                }
    
                parent[root1] = root2;
            }
            
            return new int[0];
        } 
        private int find(int[] parent, int node) {
            if (parent[node] != node) {
                parent[node] = find(parent, parent[node]); 
            }
            return parent[node];
        }
    }
}
