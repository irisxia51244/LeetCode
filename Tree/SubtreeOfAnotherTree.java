/**
 * 572，【Easy】，【Tree】
 * LeetCode 572. Subtree of Another Tree
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String sPreOrder = helper(s);
        String tPreOrder = helper(t);
        return sPreOrder.contains(tPreOrder);
    }
    
    private String helper(TreeNode node){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur == null){
                sb.append(",#");
            }else{
                sb.append("," + cur.val);
                stack.push(cur.left);
                stack.push(cur.right);
            }
        }
        return sb.toString();
    }
}
