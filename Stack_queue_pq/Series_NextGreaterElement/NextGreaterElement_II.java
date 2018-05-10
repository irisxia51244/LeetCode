/**
 * 503，【Medium】，【Stack】
 * LeetCode 503. Next Greater Element II
 * Related Topics: Stack
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1; i >= 0; i--){
            stack.push(i);
        }
        
        for(int i = nums.length-1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty()?-1:nums[stack.peek()];
            stack.add(i);
        }
        return res;
    }
}
