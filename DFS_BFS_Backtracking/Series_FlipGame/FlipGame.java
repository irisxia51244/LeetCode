/**
 * 293，【Easy】，【String】
 * LeetCode 293. Flip Game
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                String temp = s.substring(0,i) + "--" + s.substring(i+2);
                res.add(temp);
            }
        }
        return res;
    }
}
