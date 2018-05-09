/**
 * 476，【Easy】，【Bit Manipulation】
 * LeetCode 476. Number Complement
 * Related Topics: Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        String comp = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                comp += "1";
            }
            else{
                comp += "0";
            }
        }
        return Integer.parseInt(comp,2);
    }
}
