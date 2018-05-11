/**
 * 551，【Easy】，【String】
 * LeetCode 551. Student Attendance Record I
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public boolean checkRecord(String s) {
        if(s == null || s.length() == 0) return false;
        int A = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'A'){
                if(A > 0) return false;
                A++;
            }
            else if(i > 1 && c == 'L' 
                    && s.charAt(i-1) == 'L' && s.charAt(i-2) == 'L'){
                return false;
            }
        }
        return true;
    }
}
