/**
 * 367，【Easy】，【Math】【Binary Search】
 * LeetCode 367. Valid Perfect Square
 * Related Topics: Math, Binary Search
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num;
        while(lo <= hi){
            long mid = (lo+hi)/2;
            if(mid*mid == num){
                return true;
            }else if(mid*mid < num){
                lo = (int)mid+1;
            }else{
                hi = (int)mid-1;
            }
        }
        return false;
    }
}
