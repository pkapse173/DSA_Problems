
//Problem: Best Time to buy and sell stock
/*
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *       
 * OUTPUT: [[7,null],[13,0],[11,4],[10,2],[1,0]]

/*
 * Approach - Using HashMap
 * Time Complexity - O(n) - n is number of nodes in list
 * Space Complexity - O(n) Space is used by HashMap
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
package LinkedList;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
           if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();

        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}
