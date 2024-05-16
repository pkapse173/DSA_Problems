
//Problem: Merge Two Sorted Lists
/*
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 *       
 * OUTPUT: [1,1,2,3,4,4]

/*
 * Approach 1 - Iteration through both lists
 * Time Complexity - O(n+m) - n is the number of nodes in the list1 and m is number of nodes in list 2
 * Space Complexity - O(1) - Constant space
 */

package LinkedList;

public class MergeTwoSortedList {

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
       ListNode dummy = new ListNode(0);
       ListNode current = dummy;

       ListNode pointer1 = list1;
       ListNode pointer2 = list2;

        while(pointer1 != null && pointer2 !=null){
        if(pointer1.val <= pointer2.val){
            current.next = pointer1;
            pointer1 = pointer1.next;
        }else{
            current.next = pointer2;
            pointer2 = pointer2.next;
        }
            current = current.next;
        }
        
        if(pointer1 != null){
            current.next = pointer1;
        }else{
            current.next = pointer2;
        }

        return dummy.next;
    }
}
    
