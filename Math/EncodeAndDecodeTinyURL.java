import java.util.*;
/**
 * 535，【Medium】，【HashTable】【Math】
 * LeetCode 
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
 public class Codec {
    List<String> url = new ArrayList<String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        url.add(longUrl);
        return String.valueOf(url.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        if(index<url.size()){
            return url.get(index);
        }
        else{
            return "";
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
