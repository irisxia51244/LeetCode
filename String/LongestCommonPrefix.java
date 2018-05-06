import java.util.*;
/**
 * 14，【Easy】，【String】
 * LeetCode 
 * Related Topics: 
 * @author Iris Xia.
 * Method1: Time Complexity: O(nm^2) worst case, average case faster, Space Complexity: O(1)
 * Method2: Time Complexity: O(mn) average case, Space Complexity: O(1)
 */
 
class Solution {
    //Method1
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0 || strs[0].length() == 0) return "";
        String pre = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(pre)){
                pre = pre.substring(0, pre.length()-1);
            }
        }
        return pre;
    }
}
    
    //Method2: compare char at each index in each string
