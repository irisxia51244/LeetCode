/**
 * 812，【Easy】，【Math】
 * LeetCode 812. Largest Triangle Area
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public double largestTriangleArea(int[][] points) {
        if(points == null || points.length == 0) return 0;
        double maxArea = 0;
        for(int i = 0; i < points.length-2; i++){
            for(int j = i+1; j < points.length-1; j++){
                for(int k = j+1; k < points.length; k++){
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    double curArea = Math.abs(0.5*(p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1] 
                                          - p1[0]*p3[1] - p3[0]*p2[1] -p2[0]*p1[1]));
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }
}
