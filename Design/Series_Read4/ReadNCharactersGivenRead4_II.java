/**
 * 158，【Hard】，【String】
 * LeetCode 158. Read N Characters Given Read4 II - Call multiple times
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
    private int count = 0;
    private int pointer = 0;
    private char[] buff = new char[4];
    
    public int read(char[] buf, int n) {
        int index = 0;
        while(index < n){
            if(pointer == 0){
                count = read4(buff);
            }
            if(count == 0) break;
            while(pointer < count && index < n){
                buf[index++] = buff[pointer++];
            }
            if(pointer == count) pointer = 0;
        }
        return index;
    }
}
