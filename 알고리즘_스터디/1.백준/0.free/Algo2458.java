import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2458 {
	static int N,M,answer;
	static int[][] graph;
	static int max = 1000000000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		graph = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				graph[i][j] = max;
			}
		}
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			graph[start][end] = 1;
		}
		
		for(int k=1;k<=N;k++) {
			graph[k][k] = 0;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(graph[i][j]>graph[i][k]+graph[k][j]) {
						graph[i][j] = graph[i][k]+graph[k][j];
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(graph[i][j]==max && graph[j][i] == max) {
					break;
				}
				
				if(j==N) answer++;
			}
		}
		System.out.println(answer);
	}
}
