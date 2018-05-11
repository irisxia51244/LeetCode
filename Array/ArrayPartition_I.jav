/**
 * 561，【Easy】，【Array】
 * LeetCode 561. Array Partition I
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length - 1; i += 2){
            res += nums[i];
        }
        return res;
    }
}
