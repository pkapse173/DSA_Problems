//Problem: Combination Sum
/*
 * INPUT: candidates = [2,3,6,7], target = 7
 *       
 * OUTPUT: [[2,2,3],[7]]
 * Explaination: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
 */

/*
 * Approach - Backtrack(Recursion)
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    
    List<List<Integer>> resultList = new ArrayList<>();
    solve(0, candidates, new ArrayList<>(), resultList, target);
    return resultList;
    }

    private void solve(int idx, int nums[], List<Integer> temp, List<List<Integer>> list, int target){

        if(target < 0) return;

        if(target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx; i < nums.length; i++){
            temp.add(nums[i]);
            solve(i, nums, temp, list, target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
