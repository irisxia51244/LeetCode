public class Main {
	static boolean[] visited = new boolean[4];
	static String res = "";
	static int base = 0;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		String s = "11:00";
		closestTime(s);
		System.out.println(res);
	}
	
	public static void closestTime(String s) {
		res = s;
		base = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3,5));
		int[] array = new int[4];
		int count = 0;
		for(int i = 0; i < array.length; i++){
			char c = s.charAt(count);
			count++;
			array[i] = c == ':'? s.charAt(count++) -48 : c - 48;
		}
		dfs(array, 0, "");
	}
	
	public static void dfs(int[] array, int cur, String s1){
		if(cur == 4){
			int now = Integer.parseInt(s1.substring(0,2)) * 60 + Integer.parseInt(s1.substring(2, 4));
			if(now == base) return;
			int diff = now - base > 0? now - base : now - base + 24*60;
			if(diff < min){
				min = diff;
				res = s1.substring(0, 2) + ":" + s1.substring(2,4); 
			}
		}
		for(int i = 0; i < array.length; i++){
			if(visited[i] || i>0 && !visited[i-1] && array[i] == array[i-1]) continue;
			if(cur == 0 && array[i] > 2) continue;
			if(cur == 1 && (s1.charAt(0) - 48)*10 + array[i] > 23) continue;
			if(cur == 2 && array[i] > 5) continue;
			visited[i] = true;
			dfs(array, cur+1, s1+array[i]);
			visited[i] = false;
			
		}
	}
}