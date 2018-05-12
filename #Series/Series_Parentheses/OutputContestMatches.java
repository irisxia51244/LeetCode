/**
 * 544，【Medium】，【String】【Recursion】
 * LeetCode 544. Output Contest Matches
 * Related Topics: String, Recursion
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public String findContestMatch(int n) {
        if(n == 0) return "";
        String[] pairs = new String[n];
        for(int i = 0; i < n; i++){
            pairs[i] = Integer.toString(i+1);
        }
        
        while(n > 1){
            for(int i = 0; i < n/2; i++){
                pairs[i] = "(" + pairs[i] + "," + pairs[n-1-i] + ")";
            }
            n /= 2;
        }
        return pairs[0];
    }
}
