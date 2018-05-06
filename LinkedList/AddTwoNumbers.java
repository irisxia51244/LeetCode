import java.util.*;
/**
 * 2，【Medium】，【LinkedList】【Math】
 * LeetCode 2. Add Two Numbers
 * Related Topics: LinkedList, Math
 * @author Iris Xia.
 * Time Complexity: O(n), Space Complexity: O(1), ignore result list;
 */
 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null || l2 != null || carry != 0){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(carry%10);
            carry/=10;
            cur = cur.next;
        }
        return dummy.next;
    }
}
