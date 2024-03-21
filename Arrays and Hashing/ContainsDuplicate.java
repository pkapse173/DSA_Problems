//Problem: Contains Duplicate
/*
 * INPUT: [1,2,3,1]
 *       
 * OUTPUT: True
 */
/*
 * Approach 1 - Brute force approach
 * Time Complexity - O(n2)
 * Space Complexity - O(1)
 */
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}

/*
 * Approach 2 - Sorting array
 * Time Complexity - O(nlogn)
 * Space Complexity - O(1)
 */
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
}


/*
 * Approach 3 - Using HashMap
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

    HashMap<Integer,Integer> map = new HashMap<>();
    for(int num: nums){
         if(map.containsKey(num)){
            return true;
         }else{
             map.put(num, map.getOrDefault(num,0)+1);
        }
    }
    return false;
    }
}


/*
 * Approach 4 - Using HashSet
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }
}