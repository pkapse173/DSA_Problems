
//Problem: Search in a 2D Matrix
/*
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 *       
 * OUTPUT: True
 * 
 */

/*
 * Approach - Brute Force
 * Time Complexity - O(m * n) - m is number of row and n is number of column
 * Space Complexity - O(1) - Constant space
 */


 public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int[] row : matrix){
            for(int value : row){
                if(value == target){
                    return true;
                }
            }
        }
        return false;
    }
}


/*
 * Approach - Binary Search
 * Time Complexity - O(log(m * n)) - m is number of row and n is number of column
 * Space Complexity - O(1) - Constant space
 */


public class Search2DMatrix {
        public boolean searchMatrix(int[][] matrix, int target) {
            
            if(matrix.length == 0) return false;
            int m = matrix.length;
            int n = matrix[0].length;
            int low = 0;
            int high = (m * n) - 1;
            while(low <= high){
                int mid = low + (high - low)/2;
                int r = mid/n;
                int c = mid%n;
                if(matrix[r][c] == target) {
                    return true;
                }else if (matrix[r][c] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return false;
        }
    }
    
