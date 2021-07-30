import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo15649 {
	static int N,M;
	static int[] nums,ans;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		ans = new int[M];
		v = new boolean[N];
		
		comb(0);
	}
	
	public static void comb(int cnt) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				System.out.print(ans[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			v[i] = true;
			ans[cnt] = i+1;
			comb(cnt+1);
			v[i] = false;
		}
	}
}
