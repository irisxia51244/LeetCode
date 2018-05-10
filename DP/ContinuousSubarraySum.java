/**
 * 523，【Medium】，【Math】【DP】
 * LeetCode 523. Continuous Subarray Sum
 * Related Topics: Math, Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;
        int remainder = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            remainder += nums[i];
            if(k != 0) remainder%=k;
            if(map.containsKey(remainder)){
                if(i - map.get(remainder) > 1){
                    return true;
                }
            }else{
                map.put(remainder, i);
            }
        }
        return false;
    }
}
