/**
 * 389，【Easy】，【HashTable】【BitManipulation】
 * LeetCode 389. Find the Difference
 * Related Topics: HashTable, Bit Manipulation
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2: 
 */

class Solution {
    //Method1: Bit Manipulation
    //Method2
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            sum -= s.charAt(i);
            sum += t.charAt(i);
        }
        sum += t.charAt(t.length() - 1);
        return (char)sum;
    }
}
