/**
 * 33，【Medium】，【Array】【Binary Search】
 * LeetCode 33. Search in Rotated Sorted Array
 * Related Topics: Array, Binary Search
 * @author Iris Xia
 * Time Complexity: O(logn), Space Complexity: O(1);
 */

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[r]){
                if(target > nums[mid] && target <= nums[r]){
                    l = mid+1;
                }
                else{
                    r = mid;
                }
            }
            else{
                if(target > nums[mid] || target <= nums[r]){
                    l = mid+1;
                }
                else{
                    r = mid;
                }
            }
        }
        return (l==r && target != nums[l])?-1:l;
    }
}
