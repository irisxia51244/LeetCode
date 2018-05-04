import java.util.*;
/**
 * 259，【Medium】，【Array】【Two Pointers】
 * LeetCode 259. 3Sum Smaller
 * Related Topics: Array, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(n^2), Space Complexity: O(1);
 */

//nums[i] + nums[l]+ nums[r] < target => nums[i] + nums[l] + nums[from l+1 to r] < target
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n-2; i++){
            int l = i+1, r = n-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r]; 
                if(sum < target){
                    res += r - l;
                    l++;
                }else{
                    r--;
                }
            } 
        }
        return res;
    }
}
