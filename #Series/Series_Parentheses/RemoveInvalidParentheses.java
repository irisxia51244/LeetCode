/**
 * 301，【Hard】，【DFS】【BFS】
 * LeetCode 301. Remove Invalid Parentheses
 * Related Topics: DFS, BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public List<String> removeInvalidParentheses(String s) {
        int stack = 0, countL = 0,  countR = 0;
        for(char c: s.toCharArray()){
            if(c == '(') stack++;
            else if(c == ')'){
                if(stack == 0) countR++; //first parentheses is a ')'
                else stack--;
            }
        }
        countL = stack;//# of '(' need to be removed, countR: # of ')' need to be removed
        stack = 0;
        
        if(countR == 0 && countL == 0) return Arrays.asList(s);
        
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        dfs(s.toCharArray(), res, sb, 0, stack, countL, countR);
        return res;
    }
    private void dfs(char[] chars, List<String> res, StringBuilder sb, int pos, 
               int stack, int countL, int countR){
        if(stack < 0) return; //invalid parentheses
        if(pos == chars.length){
            if(countR == 0 && countL == 0) res.add(sb.toString());
            return;//removed enough invalid parentheses
        }
        char c = chars[pos];
        if(c == '('){
            int i = 1;
            while(pos+i < chars.length && chars[pos+i] ==  '(') i++;
            sb.append(chars, pos, i);
            dfs(chars, res, sb, pos+i, stack+i, countL, countR);//use it
            sb.delete(sb.length()-i, sb.length());
            
            if(countL > 0){
                dfs(chars, res, sb, pos+1, stack, countL-1, countR);//remove it
            }
        }else if(c == ')'){
            int i = 1;
            while(pos+i < chars.length && chars[pos+i] == ')') i++;
            sb.append(chars, pos, i);
            dfs(chars, res, sb, pos+i, stack-i, countL, countR);//use it
            sb.delete(sb.length()-i, sb.length());
            
            if(countR > 0){
                dfs(chars, res, sb, pos+1, stack, countL, countR-1);//remove it
            }
        }else{
            sb.append(c);
            dfs(chars, res, sb, pos+1, stack, countL, countR);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
