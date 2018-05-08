/**
 * 153，【Medium】，【Array】【Binary Search】
 * LeetCode 153. Find Minimum in Rotated Sorted Array
 * Related Topics: Array, Binary Search
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int lo = 0, hi = nums.length-1;
        while(lo < hi){
            int mid = (lo + hi)/2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return nums[lo];
    }
}
