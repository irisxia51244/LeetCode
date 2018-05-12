/**
 * 234，【Easy】，【LinkedList】【Two Pointers】
 * LeetCode 234. Palindrome Linked List
 * Related Topics: Linked List, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

/*
    快慢指针走到中间，reverse后半部分，再比较前后两半是否相同
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
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
        slow = head;
        fast = pre;
        
        while(fast != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
