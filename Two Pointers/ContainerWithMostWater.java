//Problem: Container with most water
/*
 * INPUT: height = [1,8,6,2,5,4,8,3,7]
 *       
 * OUTPUT: 49
 */

/*
 * Approach 1 - Brute Force
 * Time Complexity - O(n2) - n is number of elements in input array
 * Space Complexity - O(1) - Not using any data structure
 */

 public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        
        int n = height.length;
        int max = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i + 1; j < n; j++){
                int currentValue = Math.min(height[i], height[j]) * (j-i);
                max = Math.max(max, currentValue);
            }
        }
        return max;
    }
}

/*
 * Approach 2 - Opimized Two pointer with first and last index
 * Time Complexity - O(n) - n is number of elements in input array
 * Space Complexity - O(1) - Not using any data structure
 */

public class ContainerWithMostWater {
        public int maxArea(int[] height) {
            int FinalMax = 0;
            int i = 0;
            int j = height.length - 1;
            while(i < j){
                //Calculating current cotainer of water
                int tempMax = Math.min(height[i], height[j]) * (j-i);
                //Comparing with other previous calculated container
                FinalMax = Math.max(FinalMax, tempMax);
                if(height[i] < height[j]){
                    i++;
                }else{
                    j--;
                }
            }
        return FinalMax;
        }
    }
    

