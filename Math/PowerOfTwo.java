/**
 * 231，【Easy】，【Math】【Bit Manipulation】
 * LeetCode 231. Power of Two
 * Related Topics: Math, Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 0){
            return false;
        }
        if(n == 1 || n == 2){
            return true;
        }
        double r = Math.log10(n) / Math.log10(2);
        if(r % 1 == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
