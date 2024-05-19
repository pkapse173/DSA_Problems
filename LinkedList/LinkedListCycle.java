
//Problem: Linked List Cycle
/*
 * Input: head = [3,2,0,-4], pos = 1
 *       
 * OUTPUT: true

/*
 * Approach  - Iteration through all nodes
 * Time Complexity - O(n) - number of nodes 
 * Space Complexity - O(1) - Constant space
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
package LinkedList;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        
      if(head == null || head.next == null) return false;

      ListNode slow = head;
      ListNode fast = head;

      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) return true;
      }
      return false;
    }
}
    
