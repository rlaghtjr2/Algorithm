
import java.util.Scanner;

public class Algo11066 {
	static int T,K;
	static int[] cost,sum;
	static int[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			
			K = sc.nextInt();
			
			cost = new int[K+1];
			sum = new int[K+1];
			dp = new int[K+1][K+1];
			
			for(int i=1;i<K+1;i++) {
				cost[i] = sc.nextInt();
				sum[i] = sum[i-1] + cost[i];
//				dp[i][i] = cost[i];
			}
			
			for(int i=1;i<K+1;i++) {
				for(int j=1;j+i<K+1;j++) {
					int x = j;
					int y = j+i;
					
					dp[x][y] = Integer.MAX_VALUE;
					
					for(int k=j;k<y;k++) {
						dp[x][y] = Math.min(dp[x][y], dp[x][k]+dp[k+1][y] + sum[y]-sum[x-1]);
					}
				}
			}
			System.out.println(dp[1][K]);
			
		}
	}

}
