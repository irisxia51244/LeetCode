/**
 * 218，【Hard】，【D&C】【Heap】【BIT】【Segment Tree】
 * LeetCode 218. The Skyline Problem
 * Related Topics: Divide&Conquer, Heap, BIT, Segment Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for(int[] b : buildings){
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a,b) -> (a[0] == b[0]? a[1]-b[1]:a[0]-b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> (b-a));
        pq.offer(0);
        int pre = 0;
        for(int[] h:heights){
            if(h[1]<0){
                pq.offer(-h[1]);
            }else{
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(cur != pre){
                res.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return res;
    }
}
