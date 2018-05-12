/**
 * 377，【Medium】，【Dynamic Programming】
 * LeetCode 377. Combination Sum IV
 * 无重复项，可重复使用，只需返回方法数 
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Method1: Time Complexity: O(target*nums.length), Space Complexity: O(target);
 * Method2: 
 */

class Solution {
    /*
        Method1: Dynamic Programming
        dp[i] = sum(dp[i - num])
     */
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++){
            for(int num: nums){
                if(num <= i){
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
    
    //Method2: Backtracking, HashMap
    public int combinationSum4_2(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        return helper(nums, target, map);
    }
    
    private int helper(int[] nums, int target, HashMap<Integer, Integer> map){
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(map.containsKey(target)){
            return map.get(target);
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res += helper(nums, target-nums[i], map);
        }
        map.put(target, res);
        return res;
    }
}
