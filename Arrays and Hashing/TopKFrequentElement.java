//Problem: Top K Frequent Element
/*
 * INPUT: [1,1,1,2,2,3], k = 2
 * OUTPUT: [1,2]
 */
/*
 * Approach - Priority Queue
 * Time Complexity - O(nlogk) - n is number of elements in nums array and k is input parameter of top frequent elements
 * Space Complexity - O(n + k) - Space for HashMap O(n) and Priority Queue O(k)
 */

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int num: map.keySet()){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int [] result = new int[k];
        for(int i = k-1; i>= 0; i--){
            result[i] = pq.poll();
        }
        return result;
    }
}
    

