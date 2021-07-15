import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo11404 {
	static int N,M;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		
		graph = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(graph[i], 100001);
		}
		
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			if(graph[start][end]>weight) graph[start][end] = weight;
		}
		
		for(int k=1;k<=N;k++) {
			graph[k][k] = 0;
			
			for(int j=1;j<=N;j++) {
				for(int i=1;i<=N;i++) {
					if(graph[j][i]>graph[j][k]+graph[k][i]) {
						graph[j][i] = graph[j][k]+graph[k][i];
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(graph[i][j]==100001) System.out.print(0+" ");
				else System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}

}
