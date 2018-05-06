import java.util.*;
/**
 * 4，【Hard】，【Array】【Binary Search】【Divide & Conquer】
 * LeetCode 4. Median of Two Sorted Arrays
 * Related Topics: Array, Binary Search, Divide and Conquer
 * @author Iris Xia
 * Time Complexity: O(log(m+n)), Space Complexity: O(1);
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1 == null && nums2 == null) ||(nums1.length == 0 && nums2.length == 0)) return 0;
        int m = nums1.length, n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        int lo = 0, hi = m;
        int i = 0, j = 0;
        while(lo <= hi){
            i = lo+(hi-lo)/2;
            j = (m+n+1)/2 - i;
            if(i < m && nums2[j-1] > nums1[i]) lo++;
            else if(i > 0 && nums1[i-1] > nums2[j]) hi--;
            else break;
        }
        int left_max = 0, right_min = 0;
        if(i == 0) left_max = nums2[j-1];
        else if(j == 0) left_max = nums1[i-1];
        else left_max = Math.max(nums1[i-1], nums2[j-1]);
        if((m+n)%2 == 1) return left_max;
        
        if(i == m) right_min = nums2[j];
        else if(j == n) right_min = nums1[i];
        else right_min = Math.min(nums1[i], nums2[j]);
        
        return (left_max + right_min)/2.0;
        
    }
}
