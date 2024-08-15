//Problem: Lemonade Change
/*
 * INPUT: bills = [5,5,5,10,20]
 * OUTPUT: true
 * EXPLANATION: From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
 */
/*
 * Approach - Traversing through array and maintaing five and ten notes
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */

public class LemonadeChange {
        public boolean lemonadeChange(int[] bills) {
    
            int five = 0;
            int ten = 0;
    
            for(int bill : bills){
                if(bill == 5){
                    five++;
                }else if(bill == 10){
                    if(five == 0){
                        return false;
                    }
                    five--;
                    ten++;
                }else{
                    if(ten > 0 && five > 0){
                        ten--;
                        five--;
                    }else if(five >= 3){
                        five -= 3;
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }
    }
