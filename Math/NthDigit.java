/**
 * 400，【Easy】，【Math】
 * LeetCode 400. Nth Digit
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        while(n > len * 9 * Math.pow(10,len-1)){
            n -= len* 9 * Math.pow(10,len-1);
            len ++;
        }
        int number = (int)Math.pow(10, len-1) + (n-1)/len;
        String s = Integer.toString(number);
        return Character.getNumericValue(s.charAt((n-1)%len));
    } 
}
