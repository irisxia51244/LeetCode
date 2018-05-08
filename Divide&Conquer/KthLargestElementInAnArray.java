/**
 * 215，【Medium】，【Divide&Conquer】【Heap】
 * LeetCode 215. Kth Largest Element in an Array
 * Related Topics: Divide&Conquer, Heap
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return 0;
        return nums[quickSelect(nums, 0, nums.length-1, k)];
    }
    
    public int quickSelect(int[] nums, int l, int r, int k){
        int pivot = nums[l], i = l+1, j = r;
        while(i <= j){
            if(nums[i] < pivot && nums[j] > pivot){
                swap(nums, i++, j--);
            }
            if(nums[i] >= pivot) i++;
            if(nums[j] <= pivot) j--;
        }
        swap(nums, l, j);
        if(j+1 == k) return j;
        else if(j+1 > k) return quickSelect(nums, l, j-1, k);
        else return quickSelect(nums, j+1, r, k);
    }
    
    public void swap(int[] nums,  int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
