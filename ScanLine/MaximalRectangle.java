/**
 * 85，【Hard】，【Array】【HashTable】【DP】【Stack】
 * LeetCode 85. Maximal Rectangle
 * Related Topics: Array, HashTable, Dynamic Programming, Stack
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int res = 0;
        int[] heights = new int[matrix[0].length+1];
        heights[matrix[0].length] = 0;
        
        for(int row = 0; row < matrix.length; row++){
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < heights.length; i++){
                if(i < matrix[0].length){
                    if(matrix[row][i] == '1'){
                        heights[i]++;
                    }else heights[i] = 0;
                }
                if(stack.isEmpty() || heights[stack.peek()] < heights[i]){
                    stack.push(i);
                }else{
                    while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                        int area = heights[stack.pop()] * (stack.isEmpty()? i:i-stack.peek()-1);
                        res = Math.max(res, area);
                    }
                    stack.push(i);
                }
            }
        }
        return res;
    }
}
