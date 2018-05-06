import java.util.*;
/**
 * 640，【Medium】，【Math】
 * LeetCode 640. Solve the Equation
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String solveEquation(String equation) {
        if(equation == null || equation.length() == 0) return "";
        String[] exp = equation.split("=");
        String left = exp[0];
        String right = exp[1];
        int[] l = helper(left);
        int[] r = helper(right);
        l[0] -= r[0];
        l[1] = r[1] - l[1];
        
        if(l[0] == 0){
            return l[1] == 0?"Infinite solutions":"No solution";
        }
        return "x=" + l[1]/l[0];
    }
    
    public int[] helper(String str){
        int[] res = new int[2];
        String[] terms = str.split("(?=[+-])");
        for(String t: terms){
            if(t.equals("+x") || t.equals("x")){
                res[0]++;
            }else if(t.equals("-x")){
                res[0]--;
            }else if(t.contains("x")){
                res[0] += Integer.parseInt(t.substring(0, t.indexOf('x')));
            }else{
                res[1] += Integer.parseInt(t);
            }
        }
        return res;
    }
}
