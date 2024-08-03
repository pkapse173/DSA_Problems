//Problem: Max Area of Island
/*
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 *       
 * OUTPUT: [[2,4],[1,3],[2,4],[1,3]]
 */

/*
 * Approach - Depth First Search approach
 * Time Complexity  - O(N): N is the number of nodes in graph
 * Space Complexity - O(N): for HashMap and recursive stack
 */
package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
public class CloneGraph {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(visited.containsKey(node)) return visited.get(node);

        Node cloneNode = new Node(node.val, new ArrayList<>());

        visited.put(node, cloneNode);
        
        for(Node neighbor : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}

