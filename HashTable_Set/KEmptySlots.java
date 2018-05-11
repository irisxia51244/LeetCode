/**
 * 683，【Hard】，【Array】【BST】
 * LeetCode 683. K Empty Slots
 * Related Topics: Array, Binary Search Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        if(flowers == null || flowers.length == 0) return -1;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < flowers.length; i++){
            int cur = flowers[i];
            Integer next = treeSet.higher(cur);
            if(next!=null && next-cur == k+1){
                return i+1;
            }
            Integer pre = treeSet.lower(cur);
            if(pre!=null && cur-pre == k+1){
                return i+1;
            }
            treeSet.add(cur);
        }
        return -1;
    }
}
