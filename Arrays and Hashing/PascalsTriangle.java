//Problem: Pascals Triangle
/*
 * INPUT: numRows = 5
 *       
 * OUTPUT: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
/*
 * Approach  - Dynamic programming Approach
 * Time Complexity - O(n2) n is the number of rows
 * Space Complexity - O(n2)
 */
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();

       //Base Case:
       if(numRows == 0) return resultList;

       //Building first row for every input
       List<Integer> firstRow = new ArrayList<>();
       firstRow.add(1);
       resultList.add(firstRow);

       for(int i = 1; i < numRows; i++){
        List<Integer> newRow = resultList.get(i-1);
        List<Integer> currentRow = new ArrayList<>();

        //Start of sublist
        currentRow.add(1);

        for(int j = 1; j < i; j++){
            currentRow.add(newRow.get(j-1) + newRow.get(j));
        }

        //End of sublist
        currentRow.add(1);
        
        resultList.add(currentRow);  
       }
    return resultList;
    }
}
