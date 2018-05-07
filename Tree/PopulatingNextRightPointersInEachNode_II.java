/**
 * 117，【Medium】，【Tree】【DFS】
 * LeetCode 117. Populating Next Right Pointers in Each Node II
 * Related Topics: Tree, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        TreeLinkNode cur = root;
        while(cur!=null){
            while(cur != null){
                if(cur.left!=null){
                    if(pre!=null){
                        pre.next = cur.left;
                    }else head = cur.left;
                    pre = cur.left;
                }
                if(cur.right!=null){
                    if(pre!=null){
                        pre.next = cur.right;
                    }else head = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            pre = null;
        }
        
    }
}
