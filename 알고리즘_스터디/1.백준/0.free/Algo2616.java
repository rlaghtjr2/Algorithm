import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2616 {
	static int N,maximum;
	static int[] train,sum;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		train = new int[N+1];
		sum = new int[N+1];
		
		String[] input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			train[i+1] = Integer.parseInt(input[i]);
			sum[i+1] = sum[i]+train[i+1];
		}
		
		maximum = Integer.parseInt(br.readLine());
		
		dp = new int[4][N+1];
		
		for(int i=1;i<4;i++) {
			for(int j=i*maximum; j<=N;j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-maximum]+(sum[j]-sum[j-maximum]));
			}
		}
		System.out.println(dp[3][N]);
	}

}
