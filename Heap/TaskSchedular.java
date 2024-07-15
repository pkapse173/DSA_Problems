//Problem: Task Schedular
/*
 * Input: ["A","A","A","B","B","B"], n = 2
 *       
 * OUTPUT: 8
 * 
 */
/*
 * Approach  - Using an array approach
 * Time Complexity - O(n) : Where n is the number of tasks 
 * Space Complexity - O(1): freq array has a fixed size of 26
 */

package Heap;

import java.util.Arrays;

public class TaskSchedular {

    public int leastInterval(char[] tasks, int n) {
        
        int [] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int chunks = freq[25] - 1;
        int idle = chunks * n;

        for(int i = 24; i >= 0; i--){
            idle = idle - Math.min(chunks, freq[i]);
        }

        return idle < 0 ? tasks.length : tasks.length + idle;
    }
}

