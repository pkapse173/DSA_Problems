//Problem: Find Median from Data Stream
/*
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
 *       
 * Output: [null, null, null, 1.5, null, 2.0]
 * 
 */

/*
 * Approach - Priority Queue
    time complexity: addNumn(int num): O(log n)
                     findMedian(): O(1)
    space complexity: O(n)

 */

package Heap;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if(maxHeap.size() < minHeap.size())
        {
            maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == 0) return 0;
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (double)(maxHeap.peek() + minHeap.peek())/2;
    }
}
