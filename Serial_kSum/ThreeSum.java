import java.util.*;
/**
 * 15，【Medium】，【Array】【Two Pointers】
 * LeetCode 15. 3Sum
 * Related Topics: Array, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(n^2), Space Complexity: O(1), ignore result list;
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;
        int n = nums.length;
        Arrays.sort(nums);
        if(nums[0] > 0) return res;
      
        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = n-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l<r && nums[l] == nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(sum < 0){
                    while(l<r && nums[l] == nums[l+1]) l++;
                    l++;
                }
                else{
                    while(l<r && nums[r] == nums[r-1]) r--;
                    r--;
                }
            }
        }
        return res;
    }
}
