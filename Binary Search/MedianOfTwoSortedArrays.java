//Problem: Median of Two Sorted Arrays
/*
 * INPUT: nums1 = [1,3], nums2 = [2]
 *       
 * OUTPUT: 2.0000
 * Explanation: merged array = [1,2,3] and median is 2.
 */

/*
 * Approach - Brute Force
 * Time Complexity - O(n + m) - n and m are length of each sorted array(number of elements)
 * Space Complexity - O(n + m) - Space required to stored mergedArray
 */

public class MedianOfTwoSortedArrays {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            
            int totalLen = nums1.length + nums2.length;
            int mergedArray[] = new int[totalLen];
    
            int i = 0; 
            int j = 0; 
            int k = 0;
            
            while(i < nums1.length && j < nums2.length){
                if(nums1[i] < nums2[j]){
                    mergedArray[k++] = nums1[i++];
                }else{
                    mergedArray[k++] = nums2[j++];
                }
            }
    
            while(i < nums1.length){
                mergedArray[k++] = nums1[i++];
            }
    
            while(j < nums2.length){
                mergedArray[k++] = nums2[j++];
            }
    
            if(totalLen % 2 != 0){
                return mergedArray[totalLen/2];
            }else{
                int mid1 = mergedArray[totalLen/2];
                int mid2 = mergedArray[(totalLen/2) - 1];
        
                return (double) (mid1 + mid2)/2;
            }
    
        }
    }
    
    
}
