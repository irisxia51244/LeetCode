/**
 * 100，【Easy】，【tree】【DFS】
 * LeetCode 100. Same Tree
 * Related Topics: tree, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            
        }
        else{
            return false;
        }
    }
}
