/**
 * 448，【Easy】，【Array】
 * LeetCode 448. Find All Numbers Disappeared in an Array
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        for(int i = 0; i < nums.length; i++){
            nums[(nums[i]-1)%nums.length] += nums.length;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= nums.length){
                res.add(i+1);
            }
        }
        return res;
    }
}
