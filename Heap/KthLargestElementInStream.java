//Problem: Kth Largest Element in a Stream
/*
 * Input: ["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 *       
 * OUTPUT: [null, 4, 5, 5, 8, 8]
 * 
 */

/*
 * Approach - Priority Queue
 * Time Complexity - Constructor: O(n log k) and add method: O(k)
 * Space Complexity - O(k) - k is the largest elements in min-heap
 */
package Heap;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final int k;
    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        for(Integer x : nums){
            add(x);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
