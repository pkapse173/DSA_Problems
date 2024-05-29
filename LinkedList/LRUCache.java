//Problem: Linked List Cycle
/*
 * Input: ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 *       
 * OUTPUT: [null, null, null, 1, null, -1, null, -1, 3, 4]

/*
 * Approach  
 * Time Complexity - O(1)  
 * Space Complexity - O(capacity) 
 */

package LinkedList;

public class LRUCache {

        class Node {
            int key;
            int value;
            Node next;
            Node prev;
    
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    
        private int capacity;
        private HashMap<Integer, Node> nodeMap;
        private Node head;
        private Node tail;
    
        public LRUCache(int capacity) {
            this.capacity = capacity;
            nodeMap = new HashMap<>();
        }
    
        public int get(int key) {
            Node node = nodeMap.get(key);
            if (node == null)
                return -1;
            removeFromList(node);
            addToLast(node);
            return node.value;
        }
    
        public void put(int key, int value) {
            Node node = nodeMap.get(key);
            if (node == null) {
                node = new Node(key, value);
                nodeMap.put(key, node);
                addToLast(node);
                if (nodeMap.size() > capacity) {
                    int keyToRemove = head.key;
                    removeFromList(head);
                    nodeMap.remove(keyToRemove);
                }
            } else {
                node.value = value;
                removeFromList(node);
                addToLast(node);
            }
        }
    
        private void addToLast(Node node) {
            if (head == null) {
                node.prev = null;
                node.next = null;
                head = node;
                tail = node;
            } else {
                node.prev = tail;
                node.next = null;
                tail.next = node;
                tail = tail.next;
            }
        }
    
        private void removeFromList(Node node) {
            Node nextNode = node.next;
            Node prevNode = node.prev;
            if (node != head && node != tail) {
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                return;
            }
            if (node == tail) {
                tail = tail.prev;
            }
            if (node == head) {
                head = head.next;
            }
        }
    }