/**
 * 42，【Hard】，【Array】【Two Pointers】【Stack】
 * LeetCode 42. Trapping Rain Water
 * Related Topics: Array, Two Pointers, Stack
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int ans = 0;
        int i = 0;
        while(i < height.length){
            if(s.empty() || height[i] < height[s.peek()]) s.push(i++);
            else{
                int bottom = height[s.pop()];
                int cur = s.empty()?
                    0:(Math.min(height[i], height[s.peek()]) - bottom) * (i - s.peek() - 1);
                ans += cur;
            }
        }
        return ans;
    }
}
