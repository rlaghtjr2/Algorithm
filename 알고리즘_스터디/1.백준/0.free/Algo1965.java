import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo1965 {
	static int N;
	static int[] box;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		box = new int[N];
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		String[] input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			box[i] = Integer.parseInt(input[i]);
		}
		
		for(int i=0;i<box.length;i++) {
			int num = box[i];
			for(int j=1;j<=N;j++) {
				if(dp[j]>num) {
					dp[j] = num;
					break;
				}else if(dp[j]<num) continue;
				else break;
			}
		}
		int ans = 0;
		for(int i=1;i<=N;i++) {
			if(dp[i]==Integer.MAX_VALUE) break;
			else ans = i;
		}
		System.out.println(ans);
		
	}
	public static void print() {
		System.out.println(Arrays.toString(dp));
	}
}
