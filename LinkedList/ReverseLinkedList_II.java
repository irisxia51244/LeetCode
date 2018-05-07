/**
 * 92，【Medium】，【LinkedList】
 * LeetCode 92. Reverse Linked List II
 * Related Topics: LinkedList
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode fast = dummy, slow = dummy;
        dummy.next = head;
        
        for(int i = 0; i <= n-m; i++){
            fast = fast.next;
        }
        for(int i = 0 ; i < m-1; i++){
            slow = slow.next;
            fast = fast.next;
        }
        
        for(int i = 0; i < n - m; i++){
            ListNode node = slow.next;
            ListNode temp = node.next;
            node.next = fast.next;
            fast.next = node;
            slow.next = temp;
        }
        return dummy.next;
            
    }    
}
