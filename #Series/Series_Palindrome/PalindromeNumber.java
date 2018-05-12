/**
 * 9，【Easy】，【Math】
 * LeetCode 9. Palindrome Number
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = 0, temp = x;
        while(temp > 0){
            y = y*10 + temp%10;
            temp /= 10;
        }
        return x == y;
    }
    
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int y = 0;
        while (x>y){
    	    y = y*10 + x%10;
    	    x = x/10;
        }
        return (x==y || x==y/10);
    }
}
