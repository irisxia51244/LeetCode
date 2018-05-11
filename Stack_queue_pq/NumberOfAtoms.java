/**
 * 726，【Hard】，【HashTable】【Stack】【Recursion】
 * LeetCode 726. Number of Atoms
 * Related Topics: HashTable, Stack, Recursion
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String countOfAtoms(String formula) {
        if(formula == null || formula.length() == 0) return "";
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        int n = formula.length();
        while(i < n){
            char c = formula.charAt(i);
            i++;
            if(c == '('){
                stack.push(map);
                map = new HashMap<>();
            }
            else if(c == ')'){
                int time = 0;
                while(i < n && Character.isDigit(formula.charAt(i))){
                    time = time*10 + formula.charAt(i++)-'0';
                }
                if(time == 0){
                    time = 1;
                }
                if(!stack.isEmpty()){
                    HashMap<String, Integer> temp = map;
                    map = stack.pop();
                    for(String key: temp.keySet()){
                        map.put(key, map.getOrDefault(key, 0) + temp.get(key)*time);
                    }
                }
            }
            else{
                int j = i-1;
                while(i < n && Character.isLowerCase(formula.charAt(i))){
                    i++;
                }
                String s = formula.substring(j, i);
                int time = 0;
                while(i < n && Character.isDigit(formula.charAt(i))){
                    time = time*10 + formula.charAt(i++)-'0';
                }
                if(time == 0) time = 1;
                map.put(s, map.getOrDefault(s, 0) + time);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(String key: list){
            sb.append(key);
            if(map.get(key) > 1){
                sb.append(map.get(key));
            }
        }
        return sb.toString();
    }
}
