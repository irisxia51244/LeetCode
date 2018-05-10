/**
 * 515，【Medium】，【Tree】【DFS】【BFS】
 * LeetCode 515. Find Largest Value in Each Tree Row
 * Related Topics: Tree, DFS, BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return ans;
        }
        largestValues(root, 0);
        return ans;
    }
    
    public void largestValues(TreeNode root, int depth){
        if(ans.size()-1 < depth){
            ans.add(root.val);
        }
        else if(root.val > ans.get(depth)){
            ans.set(depth, root.val);
        }
        if(root.left != null){
            largestValues(root.left, depth+1);
        }
        if(root.right != null){
            largestValues(root.right, depth+1);
        }
    }
}
