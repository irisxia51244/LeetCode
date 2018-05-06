/**
 * 34，【Medium】，【Array】【Binary Search】
 * LeetCode 34. Search for a Range
 * Related Topics: Array, Binary Search
 * @author Iris Xia.
 * Time Complexity: O(logn), Space Complexity: O(1)
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if(nums == null || nums.length == 0) return res;
            

        int lo = 0, hi = nums.length-1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] < target) lo = mid+1;
            else hi = mid;
        }
        
        if(nums[lo] != target) return res;
        else res[0] = lo;
        
        hi = nums.length - 1;
        while(lo < hi){
            int mid = (lo + (hi-lo))/2 + 1;
            if(nums[mid] > target) hi = mid-1;
            else lo = mid;
        }
        res[1] = hi;
        return res;
    }
}
