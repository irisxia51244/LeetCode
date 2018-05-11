/**
 * 737，【Medium】，【DFS】【Union Find】
 * LeetCode 737. Sentence Similarity II
 * Related Topics: DFS, Union Find
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) return false;
        HashMap<String, String> map = new HashMap<>();

        for(String[] pair : pairs){
            String word1 = pair[0];
            String word2 = pair[1];
            
            if(!map.containsKey(word1)){
                map.put(word1, word1);
            }
            if(!map.containsKey(word2)){
                map.put(word2, word2);
            }
            union(map, word1, word2);
        }
        
        for(int i = 0; i < words1.length; i++){
            String word1 = words1[i];
            String word2 = words2[i];
            
            String father1 = map.containsKey(word1)?find(map, word1):word1;
            String father2 = map.containsKey(word2)?find(map, word2):word2;
            
            if(!father1.equals(father2)){
                return false;
            }
        }
        return true;
    }
    
    private void union(HashMap<String, String> map, String word1, String word2){
        String father1 = find(map, word1);
        String father2 = find(map, word2);
        if(!father1.equals(father2)){
            map.put(father1, father2);
        }
    }
    
    private String find(HashMap<String, String> map, String word){
        while(word != map.get(word)){
            map.put(word, map.get(map.get(word)));
            word = map.get(word);
        }
        return word;
    }

}
