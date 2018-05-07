/**
 * 57，【Hard】，【Array】【Sort】
 * LeetCode 57. Insert Interval
 * Related Topics: Array, Sort
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */


class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for(Interval i: intervals){
            if(newInterval == null || i.end < newInterval.start){
                res.add(i);
            }else if(i.start > newInterval.end){
                res.add(newInterval);
                res.add(i);
                newInterval = null;
            }else{
                newInterval.start = Math.min(i.start, newInterval.start);
                newInterval.end = Math.max(i.end, newInterval.end);
            }
        }
        if(newInterval != null) res.add(newInterval);
        return res;
    }
}
