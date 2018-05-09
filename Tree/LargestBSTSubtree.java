/**
 * 333，【Medium】，【Tree】
 * LeetCode 333. Largest BST Subtree
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    int max = 0;
    private class BST{
        int size;
        int lower;
        int upper;
        
        public BST(int size, int lower, int upper){
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }
    
    private BST helper(TreeNode root){
        if(root == null){
            return new BST(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        BST left = helper(root.left);
        BST right = helper(root.right);
        if(left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower){
            return new BST(-1, 0,0);
        }
        int size = left.size + right.size + 1;
        max = Math.max(size, max);
        return new BST(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}
