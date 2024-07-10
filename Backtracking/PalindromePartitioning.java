//Problem: Combination Sum II
/*
 * INPUT: s = "aab"
 *       
 * OUTPUT: [["a","a","b"],["aa","b"]]

/*
 * Approach - Backtrack(Recursion)
 * Time Complexity - O(n * n raise to 2) - O(n) for checking palindrome and other for recursion for chooing options
 * Space Complexity - O(n * n raise to 2) - Number of partition and O(n) for storing tempList
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
     public List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(resultList, s, path, 0);
        return resultList;
    }

    private void solve(List<List<String>> resultList, String s, List<String> tempList, int index){
        
        if(index == s.length()){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                tempList.add(s.substring(index, i+1));
                solve(resultList, s, tempList, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    boolean isPalindrome(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--))
            return false;
        }
        return true;
    }
}
