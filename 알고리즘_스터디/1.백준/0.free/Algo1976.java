import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1976 {
	static int N,M;
	static int[][] graph;
	static int[] citys;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=1;j<=N;j++) {
				
				if(Integer.parseInt(input[j-1])!=0)graph[i][j] = Integer.parseInt(input[j-1]);
				else graph[i][j] = 2000;
			}
		}
		citys = new int[M];
		String[] input = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			citys[i] = Integer.parseInt(input[i]);
		}
		
		floyd();
		
		for(int i=1;i<=N;i++) {
			graph[i][i] = 1;
		}
		for(int i=0;i<M-1;i++) {
			if(graph[citys[i]][citys[i+1]]==2000) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
	
	static public void floyd() {
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(graph[i][k]+ graph[k][j] < graph[i][j]) graph[i][j] = graph[i][k] + graph[k][j];
				}
			}
		}
	}

}
