/**
 * 281，【Medium】，【Design】
 * LeetCode 281. Zigzag Iterator
 * Related Topics: Design
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class ZigzagIterator {
    Queue<Iterator<Integer>> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if(v1.iterator().hasNext()){
            queue.offer(v1.iterator());
        }
        if(v2.iterator().hasNext()){
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> next = queue.poll();
        int ret = next.next();
        if(next.hasNext()){
            queue.offer(next);
        }
        return ret;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
