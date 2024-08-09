//Problem: 4Sum
/*
 * INPUT: nums = [1,0,-1,0,-2,2], target = 0
 *       
 * OUTPUT: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */

/*
 * Approach 1 - Two pointer approach with sorting
 * Time Complexity - O(n3) - n is number of elements in input array
 * Space Complexity - O(k) - number of valid k quadruplets, Additionally O(log n) space is used for sorting the array
 */
public class 4Sum {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            
            List<List<Integer>> resultList = new ArrayList<>();
            int n = nums.length;
    
            Arrays.sort(nums);
    
            for(int first = 0; first < n-3; first++){
                if(first > 0 && nums[first] == nums[first-1]) continue;
    
                for(int second = first+1; second < n-2; second++){
                    if(second > first+1 && nums[second] == nums[second-1]) continue;
    
                    int third = second + 1;
                    int fourth = n - 1;
    
                    while(third < fourth){
                        long sum = (long)nums[first] + nums[second] + nums[third] + nums[fourth];
    
                        if(sum == target){
                            resultList.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                            while(third < fourth && nums[third] == nums[third+1]) third++;
                            while(third < fourth && nums[fourth] == nums[fourth-1]) fourth--;
    
                            third++;
                            fourth--;
                        }else if(sum < target){
                            third++;
                        }else{
                            fourth--;
                        }
                    }
                }
            }
            return resultList;
        }
    }
