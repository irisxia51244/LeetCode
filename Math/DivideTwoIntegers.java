/**
 * 29，【Medium】，【Math】【Binary Search】
 * LeetCode 29. Divide Two Integers
 * Related Topics: Math, Binary Search
 * @author Iris Xia.
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2: 
 */

class Solution {
    //Method1
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend > 0 && divisor < 0) 
           ||(dividend < 0 && divisor > 0)) sign = -1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        if(dvd == 0 || dvd < dvs) return 0;
        long lres = helper(dvd, dvs);
        
        int res = 0;
        if(lres > Integer.MAX_VALUE){
            res = (sign == 1)?Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else{
            res = sign*(int)lres;
        }
        return res;
    }
    
    private long helper(long dvd, long dvs){
        if(dvd < dvs) return 0;
        long sum = dvs;
        long times = 1;
        while(sum + sum < dvd){
            sum += sum;
            times += times;
        }
        return times + helper(dvd-sum, dvs);
    }
    
    //Method2: Bit Manipulation
    
}
