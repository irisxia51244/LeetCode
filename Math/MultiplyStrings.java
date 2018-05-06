/**
 * 43，【Medium】，【Math】【String】
 * LeetCode 43. Multiply Strings
 * Related Topics: Math, String
 * @author Iris Xia
 * Time Complexity: O(mn), Space Complexity: O(m+n);
 */
 
 class Solution {
    public String multiply(String num1, String num2) {
        if(nums1 == null || nums2 == null 
           ||num1.equals("0") || num2.equals("0") 
           ||num1.length() == 0 ||num2.length() == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        int[] array = new int[m + n];
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n - 1; j >=0; j--){
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int index1 = i+j, index2 = i+j+1;
                temp += array[index2];
                array[index1] += temp/10;
                array[index2] = temp%10;
            }
        }
        
        for(int num: array){
            if(num!=0 || sb.length()!=0){
                sb.append(num);
            }
        }
        return sb.toString();
    }
}
