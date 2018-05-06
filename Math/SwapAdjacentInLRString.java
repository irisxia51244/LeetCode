import java.util.*;
/**
 * 777，【Medium】，【Brainteaser】
 * LeetCode 777. Swap Adjacent in LR String
 * Related Topics: Brainteaser
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */
 
 class Solution {
    public boolean canTransform(String start, String end) {
        if(start == null || end == null || start.length() == 0 
           || end.length() == 0 || start.length() != end.length()) return false;
        int r = 0, l = 0;
        for (int i = 0; i< start.length(); i++){
            char s = start.charAt(i);
            char e = end.charAt(i);
            if (s == 'R') r++;
            if (s == 'L') l++;
            if (e == 'R') r--;
            if (e == 'L') l--;

            if ((l!=0 && r!=0) || r<0 || l>0) return false;
        }
        
        if (l == 0 && r == 0) return true;
        return false;
    }
}
