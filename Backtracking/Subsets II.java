//Problem: Subsets II
/*
 * INPUT: nums = [1,2,2]
 *       
 * OUTPUT: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */

/*
 * Approach - Backtrack(Recursion)
 * Time Complexity - O(n 2n) + O(n log n)
 * Space Complexity - O(n 2n)
 */
package Backtracking;

class Subsets II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, List<Integer> tempSet, int[] nums, int start){
        if(!resultList.contains(tempSet)){
             resultList.add(new ArrayList<>(tempSet));
        }
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            tempSet.add(nums[i]);
            backtrack(resultList, tempSet, nums, i+1);
            tempSet.remove(tempSet.size() - 1); 
        }
    }
}
