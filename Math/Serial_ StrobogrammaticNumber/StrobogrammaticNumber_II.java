import java.util.*;
/**
 * 247，【Medium】，【Math】【Recursion】
 * LeetCode 247. Strobogrammatic Number II
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public List<String> findStrobogrammatic(int n) {
        if(n == 0) return new ArrayList<String>();
        
        List<String> res = new ArrayList<>( n%2 == 0? Arrays.asList("") : Arrays.asList("0", "1", "8"));
        List<String> cur = new ArrayList<>();
        
        for(int i = n; i > 1; i-=2){
            cur = res;
            res = new ArrayList<>();
            for(String s : cur){
                if(i > 3) res.add('0' + s + '0');
                res.add('1' + s + '1');
                res.add('6' + s + '9');
                res.add('8' + s + '8');
                res.add('9' + s + '6');
            }
        }   
        return res;
    }

}
