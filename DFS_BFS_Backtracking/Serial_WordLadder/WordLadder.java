/**
 * 127，【Medium】，【BFS】
 * LeetCode 127. Word Ladder
 * Related Topics: BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.length() == 0 
           || endWord == null || !wordList.contains(endWord)) return 0;
        
        int res = 1;
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> words = new HashSet<>(wordList);
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        words.remove(beginWord);
        words.remove(endWord);
        
        while(!beginSet.isEmpty()){
            HashSet<String> temp = new HashSet<>();
            for(String str: beginSet){
                char[] chars = str.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    char ch = chars[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[i] = c;
                        String s = String.valueOf(chars);
                        
                        if(endSet.contains(s)){
                            return res+1;
                        }
                        if(words.contains(s)){
                            words.remove(s);
                            temp.add(s);
                        }
                    }
                    chars[i] = ch;
                }
            }
            beginSet = temp.size() < endSet.size()? temp:endSet;
            endSet = beginSet.size() < endSet.size()? endSet:temp;
            res++;
        }
        return 0;
    }
}
