/**
 * 84，【Hard】，【Array】【Stack】
 * LeetCode 84. Largest Rectangle in Histogram
 * Related Topics: Array, Stack
 * @author Iris Xia
 * Time Complexity: O( ), Space Complexity: O();
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int h = i == heights.length? 0: heights[i];
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int index = stack.isEmpty()?-1:stack.peek();
                int area = height * (i - index - 1);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;
    }
}
