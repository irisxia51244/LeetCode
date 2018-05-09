/**
 * 338，【Medium】，【DP】【Bit Manipulation】
 * LeetCode 338. Counting Bits
 * Related Topics: Dynamic Programming, Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for(int i = 1; i <= num; i++){
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
