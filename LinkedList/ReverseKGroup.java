package LinkedList;

//Problem: Reverse K Group Linked List
/*
 * Input: head = [1,2,3,4,5], k = 2
 *       
 * OUTPUT: [2,1,4,3,5]

/*
 * Approach: Reverse LL with groups
 * Time Complexity - O(n) - n is the number of nodes in the linked list
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

public class ReverseKGroup {
        public ListNode reverseKGroup(ListNode head, int k) {
            
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = dummy;
    
        while(cur.next != null){
        for(int i = 0; i < k && cur != null; i++){
            cur =cur.next;
        }
    
        if(cur == null){
            return dummy.next;
        }
    
        ListNode next = cur.next;
        cur.next = null;
        ListNode start = pre.next;
        pre.next = reverse(start);
        start.next = next;
        pre = start;
        cur = pre;
        }
        return dummy.next;
    }
    
        private ListNode reverse(ListNode head){
            ListNode prev = null;
            ListNode cur = head;
    
            while(cur != null){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            } 
            return prev;
        }
    }
