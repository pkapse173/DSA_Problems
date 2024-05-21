//Problem: Reverse Linked List
/*
 * Input: head = [1,2,3,4]
 *       
 * OUTPUT: [1,4,2,3]

/*
 * Approach  - Iterating through once in list
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
package LinkedList;

public class ReorderList {

    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return;
        
        ListNode mid = findMiddle(head);

        ListNode head2 = reverseList(mid);

        mid.next = null;
        head = reorderList(head, head2);
    }

        //Finding the middle of the LinkedList
        private ListNode findMiddle(ListNode head){
            ListNode slow = head;
            ListNode fast = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        //Reverse the second half of the list
        private ListNode reverseList(ListNode head){
            ListNode prevNode = null;
            ListNode currNode = head;
            
            while(currNode != null){
                ListNode nextNode = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = nextNode; 
            }
            head = prevNode;
            return head;
        }

        private ListNode reorderList(ListNode head1, ListNode head2){
            ListNode originalHead = head1;

            while(head1 != null && head2 != null){
                ListNode temp1 = head1.next;
                ListNode temp2 = head2.next;

                head1.next = head2;
                head2.next = temp1;
                head1 = temp1;
                head2 = temp2;
            }
            return originalHead;

    }
}

