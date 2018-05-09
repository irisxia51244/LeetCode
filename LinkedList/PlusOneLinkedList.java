/**
 * 369，【Medium】，【LinkedList】
 * LeetCode 369. Plus One Linked List
 * Related Topics: LinkedList
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        int index = -1;
        int pos = 0;
        while(fast != null){
            index = fast.val < 9?pos:index;
            pos++;
            fast = fast.next;
        }
        
        if(index == -1){
            dummy.val = 1;
        }
        ListNode slow = head;
        for(int i = 0; i < pos; i++){
            if(i == index) slow.val++;
            if(i > index){
                slow.val = 0;
            }
            slow = slow.next;
        }
        return index == -1?dummy:head;
        
    }
}
