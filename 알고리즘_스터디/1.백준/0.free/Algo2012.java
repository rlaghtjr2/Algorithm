import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo2012 {
	static int N;
	static long ans;
	static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		rank = new int[N];
		for(int i=0;i<N;i++) {
			rank[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rank);
		
		for(int i=0;i<N;i++) {
			ans += Math.abs((i+1)-rank[i]);
		}
		System.out.println(ans);
	}

}
