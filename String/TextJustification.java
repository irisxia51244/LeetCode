/**
 * 68，【Hard】，【String】
 * LeetCode 68. Text Justification
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        int index = 0;
        while(index < words.length){
            int count = words[index].length();
            int last = index+1;
            while(last < words.length){
                if(count+words[last].length()+1 > maxWidth) break;
                count+= 1 + words[last].length();
                last++;
            }
            
            int slots = last-index-1;
            int diff = maxWidth - count;
            
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            if(last == words.length || slots == 0){
                for(int i = index+1; i < last; i++){
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for(int i = 0; i < diff; i++){
                    sb.append(" ");
                }
            }else{
                int spaces = diff/slots;
                int remainder = diff%slots;
                for(int i = index+1; i < last; i++){
                    sb.append(" ");
                    for(int j = 0; j < spaces; j++){
                        sb.append(" ");
                    }
                    if(remainder > 0){
                        sb.append(" ");
                        remainder--;
                    }
                    sb.append(words[i]);
                }
            }
            
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
}
