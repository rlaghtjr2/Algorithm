import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo13164 {
	static int N,K,ans;
	static int[] child,cost;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		child = new int[N];
		input = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			child[i] = Integer.parseInt(input[i]);
		}
		
		cost = new int[N-1];
		for(int i=0;i<N-1;i++) {
			cost[i] = child[i+1]-child[i];
		}
		//1 3 5 6 10
		Arrays.sort(cost);
		for(int i=0;i<N-K;i++) {
			ans+=cost[i];
		}
		System.out.println(ans);
		
	}

}
