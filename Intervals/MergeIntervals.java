/**
 * 56，【Medium】，【Array】【Sort】
 * LeetCode 56. Merge Intervals
 * Related Topics: Array, Sort
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */


class Solution {
    public List<Interval> merge(List<Interval> intervals) { 
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return res;
        
        intervals.sort((a, b) -> (a.start == b.start? a.end - b.end: a.start-b.start));
        res.add(intervals.get(0));
        for(Interval i : intervals){
            Interval pre = res.get(res.size() - 1);
            if(i.start > pre.end){
                res.add(new Interval(i.start, i.end));
            }else{
                res.get(res.size()-1).end = (Math.max(pre.end, i.end));
            }
        }
        return res;
    }
}
