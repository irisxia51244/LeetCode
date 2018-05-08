/**
 * 235，【Easy】，【Tree】
 * LeetCode 235. Lowest Common Ancestor of a Binary Search Tree
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //3 cases, left side, right side, diff side
        //if diff side, p, q must one < root, one > root
        if(p.val == root.val || q.val == root.val) return root;
        TreeNode node = root;
        while((p.val - node.val) * (q.val - node.val) > 0){
            node = p.val - node.val > 0? node.right:node.left;
        }
        return node;
    }
}
