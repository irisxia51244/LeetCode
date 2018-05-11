/**
 * 662，【Medium】，【Tree】
 * LeetCode 662. Maximum Width of Binary Tree
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        q.offer(root);
        map.put(root, 1);
        int width = 0;
        
        while(!q.isEmpty()){
            int start = 0;
            int end = 0;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(i == 0) start = map.get(cur);
                if(i == size-1) end = map.get(cur);
                if(cur.left != null){
                    map.put(cur.left, map.get(cur)*2);
                    q.offer(cur.left);
                }
                if(cur.right!= null){
                    map.put(cur.right, map.get(cur)*2+1);
                    q.offer(cur.right);
                }
            }
            width = Math.max(end-start+1, width);
        }
        return width;
    }
}
