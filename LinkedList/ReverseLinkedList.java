/**
 * 206，【Easy】，【LinkedList】
 * LeetCode 206. Reverse Linked List
 * Related Topics: LinkedList
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
