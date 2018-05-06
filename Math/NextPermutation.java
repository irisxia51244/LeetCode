/**
 * 31，【Medium】，【Array】
 * LeetCode 31. Next Permutation
 * Related Topics: Array
 * @author Iris Xia.
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int changeIdx = -1;
        int changeNum = 0;
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i-1] < nums[i]){
                changeIdx = i-1;
                changeNum = nums[i-1];
                break;
            }
        }
        if(changeIdx == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }
        
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] > changeNum){
                swap(nums, i, changeIdx);
                break;
            }
        }
        
        reverse(nums, changeIdx+1, nums.length-1);
    }
    
    private void reverse(int[] nums, int l, int r){
        while(l < r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    
}
