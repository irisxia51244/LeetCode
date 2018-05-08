/**
 * 241，【Medium】，【Divide&Conquer】
 * LeetCode 241. Different Ways to Add Parentheses
 * Related Topics: Divide and Conquer
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input == null || input.length() == 0) return res;
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '+'|| c == '-' || c == '*'){
                String a = input.substring(0, i);
                String b = input.substring(i+1);
                List<Integer> aList = diffWaysToCompute(a);
                List<Integer> bList = diffWaysToCompute(b);
                for(int x: aList){
                    for(int y : bList){
                        if(c == '+'){
                            res.add(x+y);
                        }else if(c == '-'){
                            res.add(x-y);
                        }else if(c == '*'){
                            res.add(x*y);
                        }
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
