/**
 * 404，【Easy】，【Tree】
 * LeetCode 404. Sum of Left Leaves
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left != null){
              if(cur.left.left == null && cur.left.right == null){
                  res += cur.left.val;
              }else{
                  stack.push(cur.left);
              }
            }
            if(cur.right != null){
                if(cur.right.left!=null || cur.right.right!=null){
                    stack.push(cur.right);
                }
            }
        }
        return res;
    }
}
