//Problem: Implement Trie (Prefix Tree)
/*
 * INPUT: ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 *       
 * OUTPUT: [null,null,null,null,false,true,true,true]
 * 
 Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
*/

/*
 * Approach  - Traverse through root to child node
    'addWord' - Time Complexity: O(L) - L is the length of word
                Space Complexity: O(L)- per word added
    'search' -  Time Complexity: 
                    1) Without wildcards: O(L)
                    2) With wildcards: O(b rais to k .(L-k)) where b is the average branching factor and k is the number of wildcard
        Space Complexity: O(L) due to recursive call
 */
package Tries;

import java.util.HashMap;

public class DesignWordDataStructure {
    private TrieNode root;
    public DesignWordDataStructure() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.map.containsKey(ch)){
                node.map.put(ch, new TrieNode());
            }
            node = node.map.get(ch);
        }
        node.isWord = true;
}
    
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node){
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(char x : node.map.keySet()){
                    if(searchInNode(word.substring(i + 1), node.map.get(x))){
                        return true;
                    }
                }
                return false;
            }else{
                if(!node.map.containsKey(ch)){
                    return false;
                }
                node = node.map.get(ch);
            }
        }
        return node.isWord;
    }
    public class TrieNode{
        public boolean isWord;
        public HashMap<Character, TrieNode> map;

        public TrieNode(){
            isWord = false;
            map = new HashMap<>();  
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

