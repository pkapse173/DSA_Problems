//Problem: Permutations
/*
 * INPUT: nums = [1,2,3]
 *       
 * OUTPUT: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

/*
 * Approach - Backtrack(Recursion)
 * Time Complexity - O(n(n!)) n is number of 
 * Space Complexity - O(n(n!))
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
    
    List<List<Integer>> resultList = new ArrayList<>();
    backtrack(resultList, new ArrayList<>(), nums);
    return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums){

        //For complete combination
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int number : nums){
            if(tempList.contains(number))
            continue; //if already number is in tempList
        

        tempList.add(number);
        backtrack(resultList, tempList, nums);
        tempList.remove(tempList.size()-1);
        }
    }
}
