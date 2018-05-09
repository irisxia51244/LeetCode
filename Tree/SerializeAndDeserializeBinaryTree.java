/**
 * 297，【Hard】，【Tree】【Design】
 * LeetCode 297. Serialize and Deserialize Binary Tree
 * Related Topics: Tree, Design
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append("null ");
                continue;
            }
            sb.append(cur.val + " ");
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] nodes = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        for(int i = 1; i < nodes.length; i++){
            TreeNode cur = q.poll();
            if(!nodes[i].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(cur.left);
            }
            if(!nodes[++i].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(cur.right);
            }
        }
        return root;
    }
       
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
