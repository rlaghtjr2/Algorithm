import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo11726 {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		dp[1] = 1;
		if(N>=2)dp[2] = 2;
		for(int i=3;i<=N;i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}

}
