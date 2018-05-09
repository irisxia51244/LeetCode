/**
 * 303，【Medium】，【DP】
 * LeetCode 303. Range Sum Query - Immutable
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        if(nums != null && nums.length != 0){
            sums = new int[nums.length];
            sums[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                sums[i] = nums[i] + sums[i-1];
            }
        }

    }
    
    public int sumRange(int i, int j) {
        if(sums == null || sums.length == 0) return 0;
        if(i == 0) return sums[j];
        return sums[j] - sums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
