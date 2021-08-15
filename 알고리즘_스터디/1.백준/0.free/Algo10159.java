import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo10159 {
	static int N,M;
	static int[][] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			graph[start][end] = 1;
			graph[end][start] = -1;
		}
		
		ployd();
		for(int i=1;i<=N;i++) {
			int cnt = N-1;
			for(int j=1;j<=N;j++) {
				if(graph[i][j]!=0) cnt--;
			}
			System.out.println(cnt);
		}
	}
	
	private static void ployd() {
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(graph[i][k] == graph[k][j] && graph[i][k]!=0) {
						graph[i][j] = graph[i][k];
					}
				}
			}
		}
	}

}
