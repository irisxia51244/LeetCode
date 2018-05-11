/**
 * 604，【Easy】，【Design】
 * LeetCode 604. Design Compressed String Iterator
 * Related Topics: Design
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class StringIterator {
    private Queue<int[]> q;
    public StringIterator(String compressedString) {
        q = new LinkedList<int[]>();
        int i = 0, n = compressedString.length();
        while(i < n){
            int j = i+1;
            while(j < n && Character.isDigit(compressedString.charAt(j))){
                j++;
            }
            int[] temp = new int[2];
            temp[0] = compressedString.charAt(i) - 'A';
            temp[1] = Integer.parseInt(compressedString.substring(i+1, j));
            q.add(temp);
            i = j;
        }
    }
    
    public char next() {
        if(q.isEmpty()) return ' ';
        int[] cur = q.peek();
        if(--cur[1] == 0) q.poll();
        return (char)('A'+cur[0]);
        
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
