/**
 * 671，【Easy】，【Tree】
 * LeetCode 671. Second Minimum Node In a Binary Tree
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    int[] mins = new int[2];
    public int findSecondMinimumValue(TreeNode root) {
        mins[0] = Integer.MAX_VALUE;
        mins[1] = Integer.MAX_VALUE;
        
        helper(root);
        
        if(mins[1] == Integer.MAX_VALUE){
            return -1;
        }
        return mins[1];
    }
    private void helper(TreeNode root){
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int value = 0;
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            value = root.val;
        }
        else{
            if(root.left != null){
                left = root.left.val;
            }
            if(root.right != null){
                right = root.right.val;
            }
            value = Math.min(left,right);
        }
        
        if(value < mins[0]){
            mins[1] = mins[0];
            mins[0] = value;
        }
        if(value > mins[0] && value < mins[1]){
            mins[1] = value;
        }
        
        helper(root.left);
        helper(root.right);
        
        return;
    }
    
}
