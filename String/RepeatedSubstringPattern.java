/**
 * 459，【Easy】，【String】
 * LeetCode 459. Repeated Substring Pattern
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() == 0) return false;
        int n = s.length();
        for(int i = n/2; i > 0; i--){
            if(n % i == 0){
                int count = n/i;
                String str = s.substring(0, i);
                int j;
                for(j = 1 ; j < count; j++){
                    if(!str.equals(s.substring(i*j, i*j+i))){
                        break;
                    }
                }
                if(j == count){
                    return true;
                }
            }
        }
        return false;
    }
}
