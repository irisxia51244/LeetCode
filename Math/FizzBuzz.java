/**
 * 412，【Easy】
 * LeetCode 412. Fizz Buzz
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i%15 == 0){
                res.add("FizzBuzz");
            }
            else{
                if(i%3 == 0){
                    res.add("Fizz");
                }
                else if(i%5 == 0){
                    res.add("Buzz");
                }
                else{
                    res.add(Integer.toString(i));
                }
            }
        }
        return res;
    }
}
