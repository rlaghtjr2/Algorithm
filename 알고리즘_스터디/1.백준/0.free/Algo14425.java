import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Algo14425 {
	static int N,M,ans;
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		set = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			set.add(s);
		}
		
		for(int i=0;i<M;i++) {
			String s = br.readLine();
			if(set.contains(s)) ans++;
		}
		
		System.out.println(ans);
	}

}
