/**
 * 639，【Hard】，【DP】
 * LeetCode 639. Decode Ways II
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int numDecodings(String s) {
        long[] res = new long[2];
        res[0] = ways(s.charAt(0));
        if(s.length() < 2) return (int) res[0];
        
        res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        for(int j = 2; j < s.length(); j++){
            char c1 = s.charAt(j-1);
            char c2 = s.charAt(j);
            long temp = res[1];
            res[1] = (res[1] * ways(c2) + res[0] * ways(c1,c2)) % 1000000007;
            res[0] = temp;
        }
        return (int)res[1];
    }
    
    private int ways(char c){
        if(c == '*') return 9;
        if(c == '0') return 0;
        return 1;
    }
    
    private static int ways(char c1, char c2){
        String str = c1+""+c2;
        if(c1 == '*' && c2 == '*'){
            return 15;
        }else if(c1 != '*' && c2 != '*'){
            return (Integer.parseInt(str) > 9 && Integer.parseInt(str) < 27)? 1: 0;
        }else if(c1 == '*'){
            return (c2 - '0' < 7)?2:1;
        }else{
            if(c1 - '0' == 0 || c1 - '0' > 2) return 0;
            return c1 - '0' == 1?9:6;
        }
    }
}
