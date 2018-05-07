/**
 * 116，【Medium】，【Tree】【DFS】
 * LeetCode 116. Populating Next Right Pointers in Each Node
 * Related Topics: Tree, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
