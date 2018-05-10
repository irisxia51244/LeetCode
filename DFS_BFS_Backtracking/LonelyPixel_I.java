/**
 * 531，【Medium】，【Array】【DFS】
 * LeetCode 531. Lonely Pixel I
 * Related Topics: Array, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int findLonelyPixel(char[][] picture) {
        if(picture == null || picture.length == 0 || picture[0].length == 0) return 0;
        int n = picture.length, m = picture[0].length;
        int firstRowCnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(picture[i][j] == 'B'){
                    if(i == 0) firstRowCnt++;
                    else if(picture[i][0] < 'Y' && picture[i][0] != 'V') picture[i][0]++;
                    if(picture[0][j] < 'Y' && picture[0][j] != 'V') picture[0][j]++;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(picture[i][j] < 'W' && (picture[0][j] == 'C' || picture[0][j] == 'X')){
                    if(i == 0) count += firstRowCnt == 1?1:0;
                    else if(picture[i][0] == 'C' || picture[i][0] == 'X') count++;
                }
            }
        }
        return count;
    }
}
