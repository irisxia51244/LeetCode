/**
 * 449，【Medium】，【Tree】
 * LeetCode 449. Serialize and Deserialize BST
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            sb.append(cur.val+" ");
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null ||data.length() == 0) return null;
        String[] str = data.split(" ");
        Queue<Integer> q = new LinkedList<>();
        for(String s : str){
            q.offer(Integer.parseInt(s));
        }
        return helper(q);
    }
    
    public TreeNode helper(Queue<Integer> q){
        if(q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> leftQ = new LinkedList<>();
        while(!q.isEmpty() && q.peek() < root.val){
            leftQ.offer(q.poll());
        }
        root.left = helper(leftQ);
        root.right = helper(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
