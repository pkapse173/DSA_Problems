//Problem: Word Ladder
/*
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 *       
 * OUTPUT: 5
 * 
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", 
 * which is 5 words long.
 */

/*
 * Approach - BFS appraoch with Set
 * Time Complexity  - O(N * L) N is number of words in wordList and L is length of each word
 * Space Complexity - O(L * E) N is number pf words in wordList and L is length of each word
 */
package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);  
        if(!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                String currentWord = queue.poll();

                for(int j = 0; j < currentWord.length(); j++){
                    char[] currentWordArray = currentWord.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        currentWordArray[j] = c;
                        String newWord = new String(currentWordArray);

                        if(newWord.equals(endWord)){
                            return level + 1;
                        }

                        if(wordSet.contains(newWord)){
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
