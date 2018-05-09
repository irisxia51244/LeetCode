/**
 * 51，【Hard】，【Backtracking】
 * LeetCode 51. N-Queens
 * Related Topics: Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n < 1) return res;
        helper(res, new int[n], 0);
        return res;
    }
    
    public void helper(List<List<String>> res, int[] queens, int pos){
        if(pos == queens.length){
            addRes(res, queens);
            return;
        }
        for(int i = 0; i < queens.length; i++){
            queens[pos] = i;
            if(isValid(queens, pos)){
                helper(res, queens, pos+1);
            }
        }
    }
    
    public boolean isValid(int[] queens, int pos){
        for(int i = 0; i < pos; i++){
            if(queens[i] == queens[pos]) return false;
            if(Math.abs(queens[pos] - queens[i]) == Math.abs(pos - i)) return false;
        }
        return true;
    }
    
    public void addRes(List<List<String>> res, int[] queens){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < queens.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < queens.length; j++){
                if(queens[i] == j){
                    sb.append('Q');
                }
                else{
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
