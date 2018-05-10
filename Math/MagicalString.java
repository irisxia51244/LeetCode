/**
 * 481，【Medium】
 * LeetCode 481. Magical String
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int magicalString(int n) {
        if(n <= 0) return 0;
        if(n <= 3) return 1;
        int res = 1;
        int p_arr = 3;
        int p_occ = 2;
        int num = 1;
        
        int[] occ = new int[n];
        occ[0] = 1; 
        occ[1] = 2;
        occ[2] = 2;
        
        while(p_arr < n){
            for(int i = 0; i < occ[p_occ] && p_arr< n; i++){
                occ[p_arr] = num;
                res += num == 1?1:0;
                p_arr++;
            }
            p_occ++;
            num = num == 1?2:1;
        }
        return res;
    }
}
