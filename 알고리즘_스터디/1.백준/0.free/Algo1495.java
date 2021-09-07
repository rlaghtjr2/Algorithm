import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1495 {
	static int N,S,M;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);
		M = Integer.parseInt(input[2]);
		
		dp = new int[N+1][M+1];
		dp[0][S] = 1;
		input = br.readLine().split(" ");
		for(int i=1;i<=N;i++) {
			int v = Integer.parseInt(input[i-1]);
			for(int j=0;j<=M;j++) {
				if(dp[i-1][j]!=0) {
					if(j+v<=M) dp[i][j+v]+=dp[i-1][j];
					if(j-v>=0) dp[i][j-v]+=dp[i-1][j];
				}
			}
		}
		
		
		for(int i=M;i>=0;i--) {
			if(dp[N][i]!=0) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}

}
