/**
 * 566，【Easy】，【Array】
 * LeetCode 566. Reshape the Matrix
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length == 0 || nums[0].length == 0) return nums;
        int n = nums.length, m = nums[0].length;
        if(n*m != r*c) return nums;
        int[][] res = new int[r][c];
        for(int i = 0; i < r*c; i++){
            res[i/c][i%c] = nums[i/m][i%m];
        }
        return res;
    }
}
