/**
 * 513，【Medium】，【Tree】【DFS】【BFS】
 * LeetCode 513. Find Bottom Left Tree Value
 * Related Topics: Tree, DFS, BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    int ans = 0, height = 0;
    public int findBottomLeftValue(TreeNode root) {
        findNextLevel(root, 1);
        return ans;
    }
    public void findNextLevel(TreeNode root, int depth){
        if(height < depth){
            ans = root.val;
            height = depth;
        }
        if(root.left != null){
            findNextLevel(root.left, depth+1);
        }
        if(root.right != null){
            findNextLevel(root.right, depth+1);
        }
    }
}
