/**
 * 496，【Easy】，【Stack】
 * LeetCode 496. Next Greater Element I
 * Related Topics: Stack
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null 
           || nums1.length == 0 || nums2.length == 0) return new int[0];
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int n : nums2){
            while(!stack.isEmpty() && stack.peek() < n){
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        for(int i = 0; i < res.length; i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
