/**
 * 7，【Easy】，【Math】
 * LeetCode 7. Reverse Integer
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            int remainder = x%10;
            int temp = res*10 + remainder;
            if((temp - remainder)/10 != res) return 0;
            res = temp;
            x /= 10;
        }
        return res;
}
