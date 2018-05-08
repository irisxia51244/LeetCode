/**
 * 230，【Medium】，【Binary Search】【Tree】
 * LeetCode 230. Kth Smallest Element in a BST
 * Related Topics: Binary Search, Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        
        while(k != 0){
            TreeNode cur = stack.pop();
            k--;
            if(k == 0) return cur.val;
            TreeNode right = cur.right;
            while(right!=null){
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}
