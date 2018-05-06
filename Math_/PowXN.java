/**
 * 50，【Medium】，【Math】【Binary Search】
 * LeetCode 50. Pow(x, n)
 * Related Topics: Math, Binary Search
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    //Method1: recursive
    public double myPow(double x, int n) {
        if(n < 0){
            return 1/x * myPow(1/x, -(n+1));
        }
        if(n == 0){
            return 1;
        }
        return n%2 == 0? myPow(x*x, n/2): x*myPow(x*x, n/2);
        
    }
    //Method2: iterative
}
