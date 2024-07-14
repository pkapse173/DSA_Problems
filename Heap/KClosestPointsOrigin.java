//Problem: K Closest Points to Origin
/*
 * Input: points = [[1,3],[-2,2]], k = 1
 *       
 * OUTPUT: [[-2,2]]
 * 
 */

/*
 * Approach - Priority Queue - Max Heap
 * Time Complexity - O(n log k): Adding element to heap - O(log k) and n i total number of elements in an array
 * Space Complexity - O(k): Max size of heap is k and storing result of array is k
 */
package Heap;

import java.util.PriorityQueue;

public class KClosestPointsOrigin {
    public int[][] kClosest(int[][] points, int k) {
    
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0] * b[0] + b[1] * b[1]) -
                                                              (a[0] * a[0] + a[1] * a[1]));
    
    for(int[] point : points){
        maxHeap.add(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
    }

    int resultList [][] = new int [k][2];
    while(k-- > 0){
        resultList[k] = maxHeap.remove();
        
    }
    return resultList;
    }
}