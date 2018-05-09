/**
 * 325，【Medium】，【HashTable】
 * LeetCode 325. Maximum Size Subarray Sum Equals k
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0; 
        int max = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(!map.containsKey(sum)) map.put(sum, i);
            if(sum == k) max = i+1;
            else if(map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum-k));//want leftest
        }
        return max;
    }
}
