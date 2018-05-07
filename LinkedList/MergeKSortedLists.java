/**
 * 23，【Hard】，【LinkedList】【Divide&Conquer】【Heap】
 * LeetCode 23. Merge k Sorted Lists
 * Related Topics: LinkedList, Divide and Conquer, Heap
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2: Time Complexity: O(nlogk), Space Complexity: O();
 */

class Solution {
    //Method1: Recursion
    public ListNode mergeKLists(ListNode[] lists) { 
        if(lists == null || lists.length == 0) return null;
        return partition(lists, 0, lists.length - 1);
    }
    
    public ListNode partition(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        else{
            int mid = (start + end)/2;
            ListNode node1 = partition(lists, start, mid);
            ListNode node2 = partition(lists, mid+1, end);
            return merge(node1, node2);
        }
    }
    
    public ListNode merge(ListNode node1, ListNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        if(node1.val < node2.val){
            node1.next = merge(node1.next, node2);
            return node1;
        }else{
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
    
    //Method2: PQ
    public ListNode mergeKLists2(ListNode[] lists){
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = 
            new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
                @Override
                public int compare(ListNode o1, ListNode o2){
                    return o1.val - o2.val;
                }          
        });
        
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        for(ListNode node: lists){
            if(node != null) 
                queue.add(node);
        }
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next != null)
                queue.add(tail.next);
        }
        return head.next;
    }
}
