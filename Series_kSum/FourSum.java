import java.util.*;
/**
 * 18，【Medium】，【Array】【HashTable】【Two Pointers】
 * LeetCode 18. 4Sum
 * Related Topics: Array, HashTable, Two Pointers
 * @author Iris Xia
 * Method 1: Time Complexity: O(n^3), Space Complexity: O(1), ignore result list;
 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int l = j+1, r = n-1;
                while(l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if(sum < target){
                        while(l < r && nums[l] == nums[l+1]) l++;
                        l++;
                    }
                    else{
                        while(l < r && nums[r] == nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
