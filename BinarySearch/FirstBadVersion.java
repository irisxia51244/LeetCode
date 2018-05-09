/**
 * 278，【Easy】，【Binary Search】
 * LeetCode 278. First Bad Version
 * Related Topics: Binary Search
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while(start < end){
            int middle = start+(end-start)/2;
            if(isBadVersion(middle)){
                end = middle;
            }
            else{
                start = middle + 1;
            }
        }
        return start;
    }
    
}
