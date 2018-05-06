/**
 * 65，【Hard】，【Math】【String】
 * LeetCode 65. Valid Number
 * Related Topics: Math, String
 * @author Iris Xia.
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s == null || s.length() == 0) return false;
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasDot = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
           
            if(i == 0){
                if(c == '+' || c == '-'&& s.length() > 1) continue;
                else if(Character.isDigit(c)) hasNum = true;
                else if(c == '.' && s.length() > 1) hasDot = true;
                else return false;
            }
           
            else if(i != s.length() - 1){
                if(c == '.'){
                    if(hasDot || hasE) return false;
                    else hasDot = true;
                }
                else if(c == 'e' || c == 'E'){
                    if(hasE || s.charAt(i-1) == '+' || s.charAt(i-1) == '-' ||!hasNum) return false;
                    else hasE = true;
                }
                else if(c == '+' || c == '-'){
                    if(s.charAt(i-1)!='e' && s.charAt(i-1) != 'E') return false;
                }
                else if(Character.isDigit(c)){
                    hasNum = true;
                }
                else{
                    return false;
                }
            }
           
            else{
                if(Character.isDigit(c)) return true; 
                else if(c == '.'){
                    if(hasDot || hasE || !Character.isDigit(s.charAt(i-1))) return false;
                    else return true;
                }
                else return false;
            }
        }
        return true;
    }
}
