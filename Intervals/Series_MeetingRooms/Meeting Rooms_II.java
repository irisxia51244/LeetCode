/**
 * 253，【Medium】，【Heap】【Greedy】【Sort】
 * LeetCode 253. Meeting Rooms II
 * Related Topics: Heap, Greedy, Sort
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int res = 0;
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.end - b.end));
        
        for(int i = 0; i < intervals.length; i++){
            while(!pq.isEmpty() && intervals[i].start >= pq.peek().end){
                 pq.poll();
            }
            pq.offer(intervals[i]);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
