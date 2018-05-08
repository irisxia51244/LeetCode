/**
 * 190，【Easy】，【Bit Manipulation】
 * LeetCode 190. Reverse Bits
 * Related Topics: Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            ans <<= 1;
            ans += n&1;
            n >>= 1;
        }
        return ans;
    }
}
