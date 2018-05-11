/**
 * 681，【Medium】，【String】
 * LeetCode 681. Next Closest Time
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private String res;
    public String nextClosestTime(String time) {
        HashSet<Integer> set = new HashSet<>();
        for(char c: time.toCharArray()){
            if(c != ':'){
                set.add(c - '0');
            }
        }
        if(set.size() == 1) return time;
        int base = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
        helper(new ArrayList<>(set), base, 0, "");
        return res;
    }
    
    private void helper(List<Integer> digits, int base, int pos, String s){
        if(pos == 4){
            int cur = Integer.parseInt(s.substring(0,2)) * 60 + Integer.parseInt(s.substring(2));
            if(cur == base) return;
            int diff = cur > base?cur - base : cur - base + 1440;
            if(diff < minDiff){
                res = s.substring(0,2) + ":" + s.substring(2);
                minDiff = diff;
            }
            return;
        }
        for(Integer i : digits){
            if(pos == 0 && i > 2) continue;
            if(pos == 1 && ((s.charAt(0) - '0') * 10 + i) > 23) continue;
            if(pos == 2 && i > 5) continue;
            helper(digits, base, pos+1, s+i);
        }
    }
}
