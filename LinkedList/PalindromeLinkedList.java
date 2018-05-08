/**
 * 234，【Easy】，【LinkedList】【Two Pointers】
 * LeetCode 234. Palindrome Linked List
 * Related Topics: Linked List, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        slow = pre;
        fast = head;
        while(slow != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
        
    }
}
