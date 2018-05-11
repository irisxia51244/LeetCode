/**
 * 800，【Math】，【String】
 * LeetCode 800. Similar RGB Color
 * Related Topics: Math, String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String similarRGB(String color) {
        if(color == null || color.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for(int i = 1; i < color.length(); i+=2){
            sb.append(helper(color.charAt(i), color.charAt(i+1)));
        }
        return sb.toString();
    }
    
    private String helper(char c1, char c2){
        int num1 = Character.isDigit(c1)? c1 - '0':c1-'a'+10;
        int num2 = Character.isDigit(c2)? c2 - '0':c2-'a'+10;
        int dist = num1 * 16 + num2;
        int num_sim = dist/17;
        num_sim += dist%17 > 17/2?1:0;
        char c = num_sim <= 9? (char)('0'+num_sim):(char)('a'+num_sim-10);
        return String.valueOf(c) + String.valueOf(c);
    }
}
