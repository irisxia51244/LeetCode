/**
 * 326，【Easy】，【Math】
 * LeetCode 326. Power of Three
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 0){
            return false;
        }
        if(n == 1 || n == 3){
            return true;
        }
        double r = Math.log10(n) / Math.log10(3);
        if(r % 1 == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
