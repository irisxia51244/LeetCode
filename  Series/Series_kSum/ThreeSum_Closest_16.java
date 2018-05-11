import java.util.*;
/**
 * 16，【Medium】，【Array】【Two Pointers】
 * LeetCode 16.  3Sum Closest
 * Related Topics: Array, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(n^2), Space Complexity: O(1);
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        int n = nums.length;
        int res = nums[0] + nums[1] + nums[n-1];
        Arrays.sort(nums);
        for(int i = 0; i < n-2; i++){
            int l = i+1, r = n-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target) return sum;
                else if(sum < target){
                    l++;
                }
                else{
                    r--;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
