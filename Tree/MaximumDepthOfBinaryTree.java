/**
 * 104，【Easy】，【Tree】【DFS】
 * LeetCode 104. Maximum Depth of Binary Tree
 * Related Topics: Tree, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            count++;
        }
        return count;
    }
}
