/**
 * 19，【Medium】，【LinkedList】【Two Pointers】
 * LeetCode 19. Remove Nth Node From End of List
 * Related Topics: LinkedList, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
        dummy.next = head;
        
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        
        while(fast!= null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}
