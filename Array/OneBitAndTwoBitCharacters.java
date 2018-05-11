/**
 * 717，【Easy】，【Array】
 * LeetCode 717. 1-bit and 2-bit Characters
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits == null || bits.length == 0) return false;
        int count = 0;
        for(int i = bits.length - 2; i >= 0; i--){
            if(bits[i] == 0) break;
            count++;
        }
        return count%2 == 0;
    }
}
