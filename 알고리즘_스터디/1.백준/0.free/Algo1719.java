import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo1719 {
	static int N,M;
	static int[][] array,ans;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		array = new int[N+1][N+1];
		ans = new int[N+1][N+1];
		for(int i=0;i<=N;i++) {
			Arrays.fill(array[i], 10001);
			array[i][i] = 0;
		}
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			
			array[start][end] = weight;
			array[end][start] = weight;
			
			ans[start][end] = start;
			ans[end][start] = end;
		}
		
		Floyd();
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) System.out.print("- ");
				else System.out.print(ans[j][i]+" ");
			}
			System.out.println();
		}
	}
	
	private static void Floyd() {
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(array[i][j]>array[i][k]+array[k][j]) {
						array[i][j] = array[i][k]+array[k][j];
						ans[i][j] = ans[k][j];
					}
				}
			}
		}
	}

}
