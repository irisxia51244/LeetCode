/**
 * 88，【Easy】，【Array】【Two Pointers】
 * LeetCode 88. Merge Sorted Array
 * Related Topics: Array, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m+n-1;
        while(j>=0){
            nums1[k--] = i>=0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }
}
