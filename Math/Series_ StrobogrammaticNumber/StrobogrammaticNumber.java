import java.util.*;
/**
 * 246，【Easy】，【HashTable】【Math】
 * LeetCode 246. Strobogrammatic Number
 * Related Topics: HashTable, Math
 * @author Iris Xia.
 * Time Complexity: O(n), Space Complexity: O(1);
 */
 
 class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return false;
        int[] chars = new int[]{0,1,-1,-1,-1,-1,9,-1,8,6};
        int l = 0, r = num.length() - 1;
        
        while(l <= r){
            int a = num.charAt(l) - '0';
            int b = num.charAt(r) - '0';
            if(chars[a] != b) return false;
            l++; 
            r--;
        }
        return true;
    }
    
}
