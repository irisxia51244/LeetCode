/**
 * 606，【Easy】，【String】【Tree】
 * LeetCode 606. Construct String from Binary Tree
 * Related Topics: String, Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }
    
    public void helper(TreeNode node, StringBuilder sb){
        if(node == null) return;
        sb.append(node.val);
        if(node.right == null && node.left == null) return;
        sb.append("(");
        helper(node.left, sb);
        sb.append(")");
        if(node.right != null){
            sb.append("(");
            helper(node.right, sb);
            sb.append(")");
        }
    }
}
