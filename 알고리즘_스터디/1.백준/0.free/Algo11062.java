import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo11062 {
	static int T,N;
	static int[] cards;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		T = Integer.parseInt(input[0]);
		
		for(int tc = 0; tc<T;tc++) {
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			input = br.readLine().split(" ");
			cards = new int[N];
			for(int i=0;i<input.length;i++) {
				cards[i] = Integer.parseInt(input[i]);
			}
			
			dp = new int[N][N];
			game(0,N-1,0);
			System.out.println(dp[0][N-1]);
		}
	}

	static int game(int left, int right, int turn) {
		if(left > right) return 0;
		if(dp[left][right]!=0) return dp[left][right];
		
		if(turn%2 == 0) {
			return dp[left][right] = Math.max(cards[left]+game(left+1,right,turn+1), cards[right] + game(left,right-1,turn+1));
		}else {
			return dp[left][right] = Math.min(game(left+1,right,turn+1), game(left,right-1,turn+1));
		}
	}
}
