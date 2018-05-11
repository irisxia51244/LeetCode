import java.util.*;
/**
 * 305，【Hard】，【Union Find】
 * LeetCode 305. Number of Islands II
 * Related Topics: Union Find
 * @author Iris Xia
 * Method 1: Time Complexity: fill array, O(mn), Union O(1), Find O(1), Space Complexity: O(mn);
 * Method 2: Integer[], init as null, O(klogmn)
 */

class Solution {
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0 || positions[0].length == 0) return res;
        
        int[] father = new int[m*n];
        Arrays.fill(father, -1);
        
        int count = 0;
        for(int[] pos: positions){
            int index = pos[0] * n + pos[1];
            father[index] = index;
            count++;
            
            for(int[] dir:dirs){
                int row = pos[0] + dir[0];
                int col = pos[1] + dir[1];
                int curIndex = row * n + col;
                if(row < 0 || row > m-1 || col < 0 || col > n-1 || father[curIndex] == -1) continue;
                int curFather = find(father, curIndex);
                if(curFather != index){
                    father[index] = curFather;
                    index = curFather;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    
    private int find(int[] father, int i){
        while(i != father[i]){
            father[i] = father[father[i]];
            i = father[i];
        }
        return i;
    }
}

