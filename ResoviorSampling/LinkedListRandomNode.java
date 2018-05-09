/**
 * 382，【Medium】，【Reservior Sampling】
 * LeetCode 382. Linked List Random Node
 * Related Topics: Reservoir Sampling
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    Random rand;
    ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.rand = new Random();
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = head;
        int ret = head.val;
        int cnt = 0;
        while(node != null){
            cnt++;
            ret = rand.nextInt(cnt) == 0?node.val:ret;
            node = node.next;
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
