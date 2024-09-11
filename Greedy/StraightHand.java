//Problem: Hand of Straights
/*
Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 */

/*
 * Approach - Greedy approach with treemap
 * Time Complexity - O(n log n + n.W) - n is total numbers in hand array
 * Space Complexity - O(n) - Space used by treemap to store elements
 */
package Greedy;

import java.util.TreeMap;

public class StraightHand {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0) return false;
        
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for(int card : hand){
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        for(int card : countMap.keySet()){
            int count = countMap.get(card);
            if(count > 0){
                for(int i = 0; i < groupSize; i++){
                    int currentCard = card + i;
                    if(!countMap.containsKey(currentCard) || countMap.get(currentCard) < count){
                        return false;
                    }
                    countMap.put(currentCard, countMap.get(currentCard) - count);
                }
            }
        }
        return true;
    }
}
