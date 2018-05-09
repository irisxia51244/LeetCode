/**
 * 359，【Easy】，【HashTable】【Design】
 * LeetCode 359. Logger Rate Limiter
 * Related Topics: HashTable, Design
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Logger {
    private HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message) && timestamp < map.get(message)){
            return false;
        }
        map.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
