/**
 * 686，【Easy】，【String】
 * LeetCode 686. Repeated String Match
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < B.length()){
            sb.append(A);
            count++;
        }
        if(sb.toString().indexOf(B) >= 0) return count;
        if(sb.append(A).toString().indexOf(B) >= 0) return ++count;
        return -1;
    }
}
