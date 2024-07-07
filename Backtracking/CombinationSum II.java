//Problem: Combination Sum II
/*
 * INPUT: candidates = [10,1,2,7,6,1,5], target = 8
 *       
 * OUTPUT: [
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

/*
 * Approach - Backtrack(Recursion)
 * Time Complexity - O(2 raise to n)
 * Space Complexity - O(2 raise to n . n) resultList stores all the combination
 */
package Backtracking;

class CombinationSum II {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            
            List<List<Integer>> resultList = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(0, candidates, resultList, new ArrayList<>(), target);
            return resultList;
        }
    
        private void backtrack(int index, int[] nums, List<List<Integer>> resultList, List<Integer> tempList, int target){
    
            if(target < 0) return;
    
            if(target == 0){
                resultList.add(new ArrayList<>(tempList));
                return;
            }
    
            for(int i = index; i < nums.length; i++){
                if(i > index && nums[i] == nums[i-1]) continue;
                    tempList.add(nums[i]);
                    backtrack(i+1, nums, resultList, tempList, target - nums[i]);
                    tempList.remove(tempList.size()-1);
            }
        }
    }
