/**
 * 81，【Medium】，【Array】【Binary Search】
 * LeetCode 81. Search in Rotated Sorted Array II
 * Related Topics: Array, Binary Search
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] < nums[r]){
                if(target > nums[mid] && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }else if(nums[mid] > nums[r]){
                if(target > nums[mid] || target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }else{
                r--;
            }
        }
        return false;
    }
}
