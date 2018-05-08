/**
 * 237，【Easy】，【LinkedList】
 * LeetCode 237. Delete Node in a Linked List
 * Related Topics: Linked List
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
