/**
 * 609，【Medium】，【HashTable】【String】
 * LeetCode 609. Find Duplicate File in System
 * Related Topics: HashTable, String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(paths == null || paths.length == 0) return res;
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(String path: paths){
            String[] files = path.split(" ");
            String dir = files[0];
            for(int i = 1; i < files.length; i++){
                int index = files[i].indexOf("(");
                String content = files[i].substring(index);
                String filename = files[i].substring(0,index);
                HashSet<String> filenames = map.getOrDefault(content, new HashSet<String>());
                filenames.add(dir +"/" +filename);
                map.put(content, filenames);
            }
        }
        for(String content: map.keySet()){
            if(map.get(content).size() > 1){
                res.add(new ArrayList<String>(map.get(content)));
            }
        }
        return res;
    }
}
