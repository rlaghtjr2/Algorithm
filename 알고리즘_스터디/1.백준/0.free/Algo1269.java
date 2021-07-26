import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class Algo1269 {
	static int N,M,ans;
	static int[] A,B;
	static HashMap<Integer, Integer> hashmap;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		hashmap = new HashMap<>();
		input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			if(!hashmap.containsKey(Integer.parseInt(input[i]))) {
				hashmap.put(Integer.parseInt(input[i]), 1);
			}else {
				hashmap.put(Integer.parseInt(input[i]), hashmap.get(Integer.parseInt(input[i]))+1);
			}
		}
		input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			if(!hashmap.containsKey(Integer.parseInt(input[i]))) {
				hashmap.put(Integer.parseInt(input[i]), 1);
			}else {
				hashmap.put(Integer.parseInt(input[i]), hashmap.get(Integer.parseInt(input[i]))+1);
			}
		}
		for(Entry<Integer, Integer> e : hashmap.entrySet()) {
			if(e.getValue()==1) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
