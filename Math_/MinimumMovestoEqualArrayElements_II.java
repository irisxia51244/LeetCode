import java.util.*;
/**
 * 462，【Medium】，【Math】
 * LeetCode 462. Minimum Moves to Equal Array Elements II
 * Related Topics: Math
 * @author Iris Xia
 * Method1: Time Complexity: O(nlogn), Space Complexity: O(1);
 * Method2: Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    //Method1:Arrays.sort()
    public int minMoves2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            res += nums[j] - nums[i];
            i++;
            j--;
        }
        return res;
    }
    //Method2:quickSelect
}
