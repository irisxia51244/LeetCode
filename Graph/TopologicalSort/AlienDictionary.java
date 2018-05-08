/**
 * 269，【Hard】，【Graph】【TopologicalSort】
 * LeetCode 269. Alien Dictionary
 * Related Topics: Graph, Topological Sort
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Set<Character>> map = new HashMap<>();
        int[] degree = new int[26];
        int count = 0;
        
        for(String word:words){
            for(char c: word.toCharArray()){
                if(degree[c-'a'] == 0){
                    degree[c-'a'] = 1;
                    count++;
                }
            }
        }
        
        for(int i = 0; i < words.length-1; i++){
            String cur = words[i];
            String next = words[i+1];
            for(int j = 0; j < Math.min(cur.length(),next.length()); j++){
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2){
                    if(!map.containsKey(c1)){
                        map.put(c1, new HashSet<Character>());
                    }
                    if(map.get(c1).add(c2)){
                        degree[c2-'a']++;
                    }
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList();
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 1){
                q.offer((char)(i+'a'));
            }
        }
        
        
        while(!q.isEmpty()){
            char cur = q.poll();
            sb.append(cur);
            if(map.containsKey(cur)){
                for(char c: map.get(cur)){
                    degree[c-'a']--;
                    if(degree[c-'a'] == 1){
                        q.offer(c);
                    }
                }
            }
        }
        
        return sb.length() == count?sb.toString():"";
    }
}
