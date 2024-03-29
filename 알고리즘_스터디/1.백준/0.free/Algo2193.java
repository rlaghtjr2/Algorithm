import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2193 {
	static int N;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		dp = new long[N][2];
		dp[0][1] = 1;
		for(int i=1;i<N;i++) {
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<2;j++) {
				System.out.print(dp[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println(dp[N-1][0]+dp[N-1][1]);
	}

}
