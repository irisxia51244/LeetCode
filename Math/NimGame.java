import java.util.*;
/**
 * 292，【Easy】，【Brainteaser】
 * LeetCode 292. Nim Game
 * Related Topics: Brainteaser
 * @author Iris Xia
 * Time Complexity: O(1), Space Complexity: O(1);
 */

class Solution {
    public boolean canWinNim(int n) {
        return n%4 != 0;
    }
}
