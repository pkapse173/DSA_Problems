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
    
/*
 * Approach - Binary Search
 * Time Complexity - O(log(n + m) - n and m are length of each sorted array(number of elements)
 * Space Complexity - O(1) - Constant Space
 */


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("Arrays are not sorted.");
    }
    
