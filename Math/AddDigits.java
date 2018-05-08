/**
 * 258，【Easy】，【Math】
 * LeetCode 258. Add Digits
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public int addDigits(int num) {
        return 1 + (num-1)%9;
    }
}
