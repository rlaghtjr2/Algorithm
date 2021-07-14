import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo1956 {
	static int V,E,min;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);
		min = Integer.MAX_VALUE;
		
		graph = new int[V+1][V+1];
		for(int i=0;i<=V;i++) {
			Arrays.fill(graph[i], 100001);
		}
		for(int i=0;i<E;i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			
			graph[start][end] = weight;
		}
		for(int k=1;k<=V;k++) {
			graph[k][k] = 0;
			for(int j=1;j<=V;j++) {
				for(int m=1;m<=V;m++) {
					if(graph[j][m]>graph[j][k]+graph[k][m]) {
						graph[j][m] = graph[j][k]+graph[k][m];
					}
				}
			}
		}
		
		for(int i=1;i<=V;i++) {
			for(int j=i+1;j<=V;j++) {
				if(graph[i][j]!=100001 && graph[j][i] != 100001)
					min = Math.min(min, graph[i][j]+graph[j][i]);
			}
		}
		
		if(min!=Integer.MAX_VALUE) System.out.println(min);
		else System.out.println(-1);
	}

}
