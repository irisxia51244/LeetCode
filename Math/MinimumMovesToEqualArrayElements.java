/**
 * 453，【Easy】，【Math】
 * LeetCode 453. Minimum Moves to Equal Array Elements
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = nums[0];
        for(int num: nums){
            if(num < min){
                min = num;
            }
        }
        int steps = 0;
        for(int num: nums){
            steps+= num - min;
        }
        return steps;
    }
}
