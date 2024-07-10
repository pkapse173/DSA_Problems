//Problem: Letter Combinations of a Phone Number
/*
 * INPUT: digits = "23"
 *       
 * OUTPUT: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */

/*
 * Approach - Backtrack(Recursion)
 * Time Complexity: O(4 raise to n)
 * Space Complexiyu: O(n . 4 raise to n)
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
 
    private static final String[] KEYS = {

            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };
    public List<String> letterCombinations(String digits) {

        List<String> resultList = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return resultList;
        }

        StringBuilder combination = new StringBuilder();
        backtrack(resultList, combination, digits, 0);
        return resultList;
    }

    private static void backtrack(List<String> resultList, StringBuilder combination, String digits, int index){

        if(index == digits.length()){
            resultList.add(combination.toString());
            return;
        }

        String letters = KEYS[digits.charAt(index) - '0'];
        for(char letter : letters.toCharArray()){
                combination.append(letter);
                backtrack(resultList, combination, digits, index+1);
                combination.deleteCharAt(combination.length() - 1);
        }
    }
}

