package LinkedList;

//Problem: Reverse Linked List
/*
 * Input: 1 -> 2 -> 3 -> 4 -> 5
 *       
 * OUTPUT: 5 -> 4 -> 3 -> 2 -> 1

/*
 * Approach 1 - Brute force
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
public class ReverseLinkedList {


    public ListNode reverseList(ListNode head) {

        if(head == null) return null;

        if(head.next == null) return head;

        ListNode preNode = null;
        ListNode currNode = head;

        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        head = preNode;
        return head;

    }
}
    
