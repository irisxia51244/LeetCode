/**
 * 477，【Medium】，【Bit Manipulation】
 * LeetCode 477. Total Hamming Distance
 * Related Topics: Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int dist = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                count+= (nums[j] >> i) & 1;
            }
            dist += count * (nums.length - count);
        }
        return dist;
    }
}
