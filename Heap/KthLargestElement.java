//Problem: Kth Largest Element in an Array
/*
 * Input: nums = [3,2,1,5,6,4], k = 2
 *       
 * OUTPUT: 5
 * 
 */

/*
 * Approach 1 - Priority Queue - Max Heap
 * Time Complexity - O(n log n): Adding element to heap - O(log n) and n is total number of elements in an array
 * Space Complexity - O(k): Max size of heap is k and storing all elements
 */
package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(Integer n : nums){
            maxHeap.add(n);
        }

        for(int i = 1; i < k; i++){
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}

/*
 * Approach 2 - Priority Queue - Min Heap
 * Time Complexity - O(n log k): Adding element to heap - O(log k) and n is total number of elements in an array
 * Space Complexity - O(k): Max size of heap is k and storing all elements
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

    for(Integer n : nums){
        minHeap.add(n);
        if(minHeap.size() > k){
            minHeap.poll();
        }
    }

    return minHeap.peek();
}
}
