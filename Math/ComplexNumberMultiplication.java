import java.util.*;
/**
 * 537，【Medium】，【Math】【String】
 * LeetCode 537. Complex Number Multiplication
 * Related Topics: Math, String
 * @author Iris Xia.
 * Time Complexity: O(n), Space Complexity: O(1);
 */
 
class Solution {
    public String complexNumberMultiply(String a, String b) {
        if(a == null || b == null || a.length() == 0 || b.length() == 0) return "";
        int splitA = a.indexOf("+");
	int splitB = b.indexOf("+");
        
	int a1 = Integer.parseInt(a.substring(0,splitA));
	int b1 = Integer.parseInt(b.substring(0,splitB));
        
	int a2 = Integer.parseInt(a.substring(splitA+1, a.length()-1));
	int b2 = Integer.parseInt(b.substring(splitB+1, b.length()-1));
        
	return (a1*b1 - a2*b2) + "+" + (a1*b2+a2*b1) + "i";
    }
}
