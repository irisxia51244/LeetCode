/**
 * 530，【Easy】,【Binary Search Tree】
 * LeetCode 530. Minimum Absolute Difference in BST
 * Related Topics: Binary Search Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    int min = Integer.MAX_VALUE;
    Integer temp = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return min;
        }
        
        getMinimumDifference(root.left);
        
        if(temp != null){
            min = Math.min(min, Math.abs(root.val - temp));
        }
        
        temp = root.val;

        getMinimumDifference(root.right);
        
        return min;
        
    }
}
