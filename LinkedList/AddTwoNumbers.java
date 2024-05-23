
//Problem: Add Two Numbers
/*
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 *       
 * OUTPUT: [7,0,8]

/*
 * Approach  - Iteration through all nodes
 * Time Complexity - O(max(n * m)) - n and m are max length of each linkedlist
 * Space Complexity - O(max(n * m)) - For creating a new linkedlist to store nodes
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
class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode(0);
        ListNode ptr = result;

        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = 0 + carry;
            
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        if(carry == 1) 
        ptr.next = new ListNode(1);
        return result.next;
    }
}
    
}
