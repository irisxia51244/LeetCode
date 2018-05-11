/**
 * 817，【Medium】，【LinkedList】
 * LeetCode 817. Linked List Components
 * Related Topics: LinkedList
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int numComponents(ListNode head, int[] G) {
        if(head == null || G == null || G.length == 0) return 0;
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int g: G){
            set.add(g);
        }
        
        ListNode node = head;
        while(node!= null){
            if(set.contains(node.val) && (node.next == null || !set.contains(node.next.val))){
                res++;
            }
            node = node.next;
        }
        return res;
    }
}
