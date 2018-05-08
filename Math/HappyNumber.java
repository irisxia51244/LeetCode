/**
 * 202，【Easy】，【HashTable】【Math】
 * LeetCode 202. Happy Number
 * Related Topics: HashTable, Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<Integer>();
        int sum = n;
        while(sumSet.add(sum)){
            sum = getSum(sum);
            if(sum == 1){
                return true;
            }
        }
        return false;
        
    }
    
    private int getSum(int n){
        String num = Integer.toString(n);
        int sum = 0;
        for(int i = 0; i < num.length(); i++){
            int temp = Integer.valueOf(num.substring(i,i+1));
            sum += temp * temp;
        }
        return sum;
    }
}
