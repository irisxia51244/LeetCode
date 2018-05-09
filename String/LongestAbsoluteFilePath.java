/**
 * 388，【Medium】
 * LeetCode 388. Longest Absolute File Path
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        int max = 0;
        String[] paths = input.split("\n");
        int[] len = new int[paths.length+1];
        for(String p: paths){
            int level = p.lastIndexOf("\t")+1;
            int curLen = len[level]+p.length()-level+1;
            len[level+1] = curLen;
            if(p.contains(".")){
                max = Math.max(max, curLen-1);
            }
            
        }
        return max;
    }
}
