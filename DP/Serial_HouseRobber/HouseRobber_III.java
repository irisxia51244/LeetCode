/**
 * 337，【Medium】，【Tree】【DFS】
 * LeetCode 337. House Robber III
 * Related Topics: Tree, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
        
    }
    
    private int[] helper(TreeNode node){
        if(node == null) return new int[2];
        int[] res = new int[2];
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        res[0] = left[1] + right[1] + node.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
        
    }
}
