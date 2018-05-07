/**
 * 69，【Easy】，【Math】【Binary Search】
 * LeetCode 69. Sqrt(x)
 * Related Topics: Math, Binary Search
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2:
 */


class Solution {
    //Method1: Newton
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x < 4) return 1;
        int start = 1, end = x;
        while(start < end){
            int mid = (start + end)/2;
            if(x/mid >= mid && x/(mid+1) < (mid+1)){
                return mid;
            }else if(x/mid < mid){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    
    //Method2: Binary Search
}
