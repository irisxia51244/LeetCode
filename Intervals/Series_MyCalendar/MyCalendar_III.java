/**
 * 732，【Hard】，【Segment Tree】【BST】
 * LeetCode 732. My Calendar III
 * Related Topics: Segment Tree, Binary Search Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class MyCalendarThree {
    private TreeMap<Integer, Integer> events;
    public MyCalendarThree() {
        events =  new TreeMap<>();
    }
    public int book(int start, int end) {
        int intersect = 0, k = 0;
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0) - 1);
        for(Integer i : events.values()){
            k = Math.max(k, intersect+=i);
        }
        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
