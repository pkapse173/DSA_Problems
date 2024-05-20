
//Problem: Remove Nth Node from End
/*
 * Input: head = [1,2,3,4,5], n = 2
 *       
 * OUTPUT: [1,2,3,5]

/*
 * Approach - Iteration through slow and fast pointer
 * Time Complexity - O(n) - n is the length of the node
 * Space Complexity - O(1) - Constant space
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
package LinkedList;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count = 0;

        while(count <= n){
            fast = fast.next;
            count++;
        }
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
         ListNode temp = slow.next;
         slow.next = temp.next;
         temp.next = null;

        return dummy.next;          
    }
}
