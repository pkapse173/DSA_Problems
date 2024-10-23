//Problem: Kids With the Greatest Number of Candies
/*
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true] 
Explanation: If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
 */


 /*
 * Approach 1 - Brute force approach
 * Time Complexity - O((n2) -  where n is the number of elements in the 'candies' array.
 * Space Complexity - O(n) - where n is the number of elements in the 'candies' array.
 */

 class kidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> resultList = new ArrayList<>();
     
        int n = candies.length;

        for(int i = 0; i < n; i++){
               boolean check = true;
            for(int j = 0; j < n; j++){
                if((i != j) && (candies[i] + extraCandies < candies[j])){
                    check = false;
                }
            }
            resultList.add(check);
        }
        return resultList;
    }
}

/*
 * Approach 2 - Two pass traversal approach
 * Time Complexity - O((n) -  where n is the number of elements in the 'candies' array.
 * Space Complexity - O(n) - where n is the number of elements in the 'candies' array.
 */


public class kidsWithCandies {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            
            List<Boolean> resultList = new ArrayList<>();
            
            //Take max candy count
            int maxCandy = 0;
            for(int candy : candies){
                if(candy > maxCandy){
                    maxCandy = candy;
                }
            }
            //Storing each kid result
            for(int candy : candies){
                resultList.add(candy + extraCandies >= maxCandy);
            }
        return resultList;
        }
}
