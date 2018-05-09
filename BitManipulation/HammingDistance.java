/**
 * 461，【Easy】，【Bit Manipulation】
 * LeetCode 461. Hamming Distance
 * Related Topics: Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int count = 0;
        while(xor!=0){
            count += xor&1;
            xor >>= 1;
        }
        return count;
    }
}
