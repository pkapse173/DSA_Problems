//Problem: 3Sum
/*
 * INPUT: nums = [-1,0,1,2,-1,-4]
 *       
 * OUTPUT: [[-1,-1,2],[-1,0,1]]
 */

/*
 * Approach 1 - Brute Force
 * Time Complexity - O(n3) - n is number of elements in input array
 * Space Complexity - O(n3) 
 */
public class 3Sum {
        public List<List<Integer>> threeSum(int[] nums) {
    
        Set<List<Integer>> result = new HashSet<>(); 
        int n = nums.length;   
        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(result);
        }
    }

/*
 * Approach 2 - Optimized Two pointer with sorting
 * Time Complexity - O(n2) - n is number of elements in an input array
 * Space Complexity - O(log n) - auxilary space complexity due to sorting
 */

 class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            //handling outer duplicacy
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = n-1;
            while(l < r){
                int count = nums[i] + nums[l] + nums[r];
                if(count == 0){
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    result.add(list);
                    l++;
                    r--;
                    //Handling inner duplicacy
                    while(l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                    while(l < r && nums[r] == nums[r+1]){
                        r--;
                    }
                }else if(count > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return result;
    }
}
    

