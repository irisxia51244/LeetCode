/**
 * 346，【Easy】，【Design】【Queue】
 * LeetCode 346. Moving Average from Data Stream
 * Related Topics: Design, Queue
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class MovingAverage {
    private int[] window;
    private int count, pos;
    private long sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        pos = 0;
        sum = 0;
        count = 0;
    }
    
    public double next(int val) {
        if(count < window.length){
            count++;
        }
        else{
            sum -= window[pos];
        }
        window[pos] = val;
        pos = (pos + 1) % window.length;
        sum += val;
        
        return (double)sum/count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
