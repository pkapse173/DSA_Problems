//Problem: Two Sum
/*
 * INPUT: [3,5,7,9] target = 8
 * OUTPUT: [0,1]
 */
/*
 * Approach 1 - Brute Force
 * Time Complexity - O(n2)
 * Space Complexity - O(1)
 */

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    
    List<Integer> result = new ArrayList<>();
    int n = nums.length;
    for(int i = 0; i < n; i++){
        for(int j = i+1; j < n; j++){
            if(nums[i] + nums[j] == target){
                result.add(i);
                result.add(j);
            }
        }
    }
    int[] resultArray = result.stream().mapToInt(Integer::intValue).toArray();
    return resultArray;
    }
}


/*
 * Approach 2 - Using Hash Table(One pass)
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int expected = target - nums[i];

            if (map.containsKey(expected)) {
                return new int[]{map.get(expected), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}