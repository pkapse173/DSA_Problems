//Problem: Partition Labels
/*
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 */

/*
 * Approach - 
 * Time Complexity - O(n) - n is the number of char in S    
 * Space Complexity - O(n) - Sapce taken by result array for an output
 */
package Greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
       int[] lastOccurence = new int[26];

       for(int i = 0; i < s.length(); i++){
        lastOccurence[s.charAt(i) - 'a'] = i;
       }

       List<Integer> result = new ArrayList<>();
       int start = 0;
       int end = 0;

       for(int i = 0; i < s.length(); i++){
        end = Math.max(end, lastOccurence[s.charAt(i) - 'a']);

        if(i == end){
            result.add(end - start + 1);
            start = i + 1;
        }
       }
    return result;
    }
}
