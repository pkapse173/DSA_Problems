//Problem: Merge K Sorted Lists
/*
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 *       
 * OUTPUT: [1,1,2,3,4,4,5,6]

/*
 * Approach - Using Min Heap
 * Time Complexity - O(N log k)  
 * Space Complexity - O(k) 
 */

package LinkedList;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) heap.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                heap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}
