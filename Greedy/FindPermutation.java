/**
 * 484，【Medium】，【Greedy】
 * LeetCode 484. Find Permutation
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int[] findPermutation(String s) {
        if(s == null || s.length() == 0){
            return new int[0];
        }
        int[] res = new int[s.length()+1];
        for(int i = 0; i < res.length; i++){
            if(i < s.length() && s.charAt(i) == 'D'){
                int j = i;
                while(i < s.length() && s.charAt(i) == 'D'){
                    i++;
                }
                helper(res, i, j);
            }
            else{
                res[i] = i+1;
            }
        }
        return res;
    }
    
    private void helper(int[] res, int i, int j){
        while(j <= i){
            res[i] = j+1;
            res[j] = i+1;
            j++;
            i--;
        }
    }
}
