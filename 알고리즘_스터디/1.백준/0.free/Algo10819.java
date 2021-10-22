import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo10819 {
	static int N,ans;
	static int[] array,s;
	static boolean[] v;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		s = new int[N];
		v = new boolean[N];
		String[] input = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(input[i]);
		}
		
		solve(0);
		System.out.println(ans);
	}
	
	private static void solve(int cnt) {
		if(cnt==N) {
			sum();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			v[i] = true;
			s[cnt] = array[i];
			solve(cnt+1);
			v[i] = false;
		}
	}
	
	private static void sum() {
		int sum = 0;
		for(int i=0;i<N-1;i++) {
			sum+=Math.abs(s[i]-s[i+1]);
		}
		ans = Math.max(sum, ans);
	}
}
