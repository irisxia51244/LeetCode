/**
 * 67，【Easy】，【Math】【String】
 * LeetCode 67. Add Binary
 * Related Topics: Math, String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int bitA = i>=0? a.charAt(i--) - '0':0;
            int bitB = j>=0? b.charAt(j--) - '0':0;
            int temp = bitA^bitB^carry;
            carry = (bitA+bitB+carry)/2;
            sb.append(temp);
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
