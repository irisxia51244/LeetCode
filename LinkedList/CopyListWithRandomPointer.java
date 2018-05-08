/**
 * 138，【Medium】，【HashTable】【LinkedList】
 * LeetCode 138. Copy List with Random Pointer
 * Related Topics: HashTable, LinkedList
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode cur = head;
        RandomListNode next;
        
        while(cur != null){
            next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        
        cur = head;
        while(cur != null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy;
        RandomListNode copyCur = dummy;
        while(cur != null){
            next = cur.next.next;
            copy = cur.next;
            copyCur.next = copy;
            copyCur = copy;
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }
}
