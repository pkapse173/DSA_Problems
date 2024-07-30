//Problem: Implement Trie (Prefix Tree)
/*
 * INPUT: ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 *       
 * OUTPUT: [null, null, true, false, true, null, true]
 * 
 Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
*/

/*
 * Approach  - Traverse through root to child node
 * Time Complexity - Insert - O(m): m is the length of word being inserted
 *                   Search - O(m): m is the length of word being searched
 *                   StartsWith - O(m): m is the length of the prefix
 * Space Complexity - Insert - O(m * n): m is the length of longest word and n is the number of words in trie
 *                   Search - O(1)
 *                   StartsWith - O(1) 
 */

package Tries;

public class ImplementTries {
        private TrieNode root;
        public ImplementTries() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                int index = ch - 'a';
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }
        
        public boolean search(String word) {
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                int index = ch - 'a';
                if(node.children[index] == null){
                    return false;
                }
                node = node.children[index];
            }
            return node.isEndOfWord;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(char ch : prefix.toCharArray()){
                int index = ch - 'a';
                if(node.children[index] == null){
                    return false;
                }
                node = node.children[index];
            }
            return true;
            }
        public class TrieNode{
            private TrieNode[] children;
            private boolean isEndOfWord;
    
            public TrieNode(){
                children = new TrieNode[26];
                isEndOfWord = false;
            }
        }
    }
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
