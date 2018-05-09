/**
 * 406，【Medium】，【Greedy】
 * LeetCode 406. Queue Reconstruction by Height
 * Related Topics: Greedy
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0 || people[0].length == 0){
            return new int[0][0];
        }
        
        Arrays.sort(people, (a,b) -> a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
