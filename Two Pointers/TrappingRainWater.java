//Problem: Trapping Rain Water
/*
 * INPUT: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 *       
 * OUTPUT: 6
 */
/*
 * Approach  - Two pointer
 * Time Complexity - O(n) - n is length of array
 * Space Complexity - O(n) - Space taken by left and right array
 */

public class TrappingRainWater {
    
        public int trap(int[] height) {
    
        int n = height.length;
        int[] right = new int[n];
        int[] left = new int[n];
    
        //filling left array
        left[0] = height[0];
        for(int i=1; i<n; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        //feeling right array
        right[n-1] = height[n-1];
        for(int j = n-2; j>=0; j--){
            right[j] = Math.max(right[j+1], height[j]);
        }
        //getting count at each index
        int count = 0;
        for(int i=0; i<n; i++){
            count += (Math.min(left[i], right[i]) - height[i]);
        }
        return count;  
        }   
    }

