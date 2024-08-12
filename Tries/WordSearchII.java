//Problem: Word Search II
/*
 * INPUT: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], 
 * words = ["oath","pea","eat","rain"]
 *       
 * OUTPUT: ["eat","oath"]
/*
 * Approach - Using Trie with DFS
 * Time Complexity - O(O(N * L + M * N * 4^L)) - Building trie node takes (O(L * N)) N is number of words and L is max word length
 *                                              M and N are number of rows and column of board and each cell explores in all 4 directions so for 
 *                                              worst case for Longest word it would be 4^L
 * Space Complexity - O(N * L) - N words and each word of length L contributes to  L nodes in trie
 */
package Tries;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        //Construct Trie
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                int index = c - 'a';
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();
                    }
                    node = node.children[index];
            }
            node.word = word;
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(root.children[board[i][j] - 'a'] != null){
                    dfs(board, i, j, result);
                }
            }
        }
        return result;
}
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result){
        char c = board[i][j];
        int index = c - 'a';
        TrieNode currentNode = node.children[index];

        if(currentNode == null) return;

        if(currentNode.word != null){
            result.add(currentNode.word);
            currentNode.word = null;
        }
        board[i][j] = '#';

        if (i > 0) dfs(board, i - 1, j, currentNode, result);
        if (j > 0) dfs(board, i, j - 1, currentNode, result);
        if (i < board.length - 1) dfs(board, i + 1, j, currentNode, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, currentNode, result);
        

        board[i][j] = c;
    }
}
