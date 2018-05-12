/**
 * 479，【Easy】
 * LeetCode 479. Largest Palindrome Product
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int largestPalindrome(int n) {
        if(n == 1){
    		return 9;
    	}
        long bound = (long)Math.pow(10,n) - 1;
        long max = bound * bound;
        for(long i = bound - 2; i > 0; i--){
        	long pldrm = Long.valueOf(i + new StringBuilder().append(i).reverse().toString());
        	for(long j = bound; j*j >= pldrm; j--){
        		if(pldrm%j == 0){
        			return (int)(pldrm%1337);
        		}
        	}
        }
    	return 0;
    }
}
