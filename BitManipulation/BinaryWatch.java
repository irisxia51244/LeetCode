/**
 * 401，【Easy】，【Backtracking】【Bit Manipulation】
 * LeetCode 401. Binary Watch
 * Related Topics: Backtracking, Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<String> readBinaryWatch(int num){
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 60; j++){
                if(Integer.bitCount(i) + Integer.bitCount(j) == num){
                    String currentString = Integer.toString(i) + ":";
                    if(j < 10){
                        currentString += "0";
                    }
                    currentString += Integer.toString(j);
                    ans.add(currentString);
                }
            }
        }
        return ans;
    }
}
