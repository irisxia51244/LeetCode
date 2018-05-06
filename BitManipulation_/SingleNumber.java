import java.util.*;
/**
 * 136，【Easy】，【HashTable】【Bit Manipulation】
 * LeetCode 136. Single Number
 * Related Topics: HashTable, Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        for(int n : nums){
            res ^= n;
        }
        return res;
    }
}
