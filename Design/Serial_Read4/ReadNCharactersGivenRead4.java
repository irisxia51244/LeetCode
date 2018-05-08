/**
 * 157，【Easy】，【String】
 * LeetCode 157. Read N Characters Given Read4
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(n == 0) return 0;
        //pointer [0, n-1], number of characters read, count[0,4]
        //if count < 4, only left < 4 chars
        int pointer = 0, count = 4;
        char[] buff = new char[4];
        while(count == 4){
            count = read4(buff);
            for(int i = 0; i < count && pointer < n; i++){
                buf[pointer++] = buff[i];
            }
        }
        return pointer;
    }
}
