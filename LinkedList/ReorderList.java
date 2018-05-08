/**
 * 143，【Medium】，【LinkedList】
 * LeetCode 143. Reorder List
 * Related Topics: LinkedList
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = null;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            tail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        tail.next = null;
        ListNode head2 = reverse(slow);
        merge(dummy.next,head2);
    }
    
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
    
    private void merge(ListNode head1, ListNode head2){
        while(head1 != head2){
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            if(temp1 == null) break;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
    }
}
