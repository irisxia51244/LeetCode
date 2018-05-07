/**
 * 25, 【Hard】，【LinkedList】
 * LeetCode 25. Reverse Nodes in k-Group
 * Related Topics: LinkedList
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;        
        ListNode dummy = new ListNode(0);
        dummy.next = head;        
        ListNode pre = dummy, cur = dummy;
        while(true){
            for(int i = 0; i < k && cur != null; i++){
                cur = cur.next;
            }
            if(cur == null) break;
            head = pre.next;
            for(int i = 0; i < k-1; i++){
                ListNode temp = pre.next;
                pre.next = temp.next;
                temp.next = cur.next;
                cur.next = temp;
            }
            cur = head;
            pre = head;
        }
        return dummy.next;
    }
}
