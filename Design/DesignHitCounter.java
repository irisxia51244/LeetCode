/**
 * 362，【Medium】，【Design】
 * LeetCode 362. Design Hit Counter
 * Related Topics: Design
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class HitCounter {
    private int[] times;
    private int[] counts;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        counts = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp%300;
        if(times[index] != timestamp){
            times[index] = timestamp;
            counts[index] = 1;
        }
        else{
            counts[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int ret = 0;
        for(int i = 0; i < 300; i++){
            ret+=timestamp - times[i] < 300?counts[i]:0;
        }
        return ret;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
