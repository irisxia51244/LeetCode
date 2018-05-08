/**
 * 252，【Easy】，【Sort】
 * LeetCode 252. Meeting Rooms
 * Related Topics: Sort
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length < 2) return true;
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end) return false;
        }
        return true;
    }
}
