//Problem: Last Stone Weight
/*
 * Input: stones = [2,7,4,1,8,1]
 *       
 * OUTPUT: 1
 * 
 */
/*
 * Approach 1 - Brute Force
 * Time Complexity - O(n . n log n) : Where n is for iterating all the elements in array from while loop and n log n for sorting an array
 * Space Complexity - O(n): input array stones
 */

 public class lastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        
     int n = stones.length;

     while(n > 1){

        Arrays.sort(stones , 0 , n);
        int x = stones[n-1];
        int y = stones[n-2];

        if(x == y ){
            n = n - 2;
        }else{
            stones[n-2] = x - y;
            n = n - 1;
        }
     }

    return n == 0 ? 0 : stones[0];
    }
 }




/*
 * Approach - Priority Queue - maxHeap
 * Time Complexity - O(n log n) - Require to add and remove stones from maxHeap
 * Space Complexity - O(n) - Space taken by Priority Queue to store all the elements
 */
package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : stones){
            maxHeap.add(n);
        }

        while(maxHeap.size() > 1){
        int y = maxHeap.poll();
        int x = maxHeap.poll();
        
            if(x != y){
                maxHeap.add(y-x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}