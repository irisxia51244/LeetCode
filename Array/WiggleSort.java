/**
 * 280，【Medium】，【Array】【Sort】
 * LeetCode 280. Wiggle Sort
 * Related Topics: Array, Sort
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null) return;
        int pos = 1;
        while(pos < nums.length){
            if(pos%2 == 1){
                if(nums[pos-1] > nums[pos]){
                    swap(nums, pos-1);
                }
            }
            else{
                if(nums[pos-1] < nums[pos]){
                    swap(nums,pos-1);
                }
            }
            pos++;
        }
        return;
    }
    
    private void swap(int[] nums, int index){
        int temp = nums[index];
        nums[index] = nums[index+1];
        nums[index+1] = temp;
        return;
    }
}
