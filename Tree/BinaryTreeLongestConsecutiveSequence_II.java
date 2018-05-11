/**
 * 549，【Medium】，【Tree】
 * LeetCode 549. Binary Tree Longest Consecutive Sequence II
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    int max = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, root.val);
        return max;
    }
    
    private int helper(TreeNode node, Integer pre){
        if(node == null) return 0;
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        
        if(left * right < 0){
            max = Math.max(max, Math.abs(left) + Math.abs(right)+1);
        }else{
            max = Math.max(max, Math.max(Math.abs(left), Math.abs(right)) + 1);
        }

        if(node.val == pre+1) return 1 + Math.max(0, Math.max(left, right));
        else if(node.val == pre-1) return -1 + Math.min(0, Math.min(left, right));
        return 0;
        
    }
}
