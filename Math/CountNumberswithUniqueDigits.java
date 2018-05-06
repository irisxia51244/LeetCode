import java.util.*;
/**
 * 357，【Medium】，【Math】【DP】【Backtracking】
 * LeetCode 357. Count Numbers with Unique Digits
 * Related Topics: Math, Dynamic Programming, Backtracking
 * @author Iris Xia
 * Method1: Time Complexity: O(1), Space Complexity: O(1);
 */

class Solution {
    //Method1
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        
        int res = 10, base = 9;
        for(int i = 2; i <= n && i <= 10; i++){
            base *= (9-i+2);
            res += base;
        }
        return res;
    }
}
