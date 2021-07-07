import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;



class Edge{
	int end;
	int weight;
	
	Edge(int _end, int _weight){
		end = _end;
		weight = _weight;
	}
}

public class Algo10282 {
	static int M,N,D,T,C,num,time;
	static ArrayList<Edge>[] graph;
	static boolean[] visit;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		T = Integer.parseInt(input[0]);
		
		while(T>0) {
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			D = Integer.parseInt(input[1]);
			C = Integer.parseInt(input[2]);
			
			visit = new boolean[N+1];
			dist = new int[N+1];
			graph = new ArrayList[N+1];
			
			for(int i=0;i<=N;i++) {
				graph[i] = new ArrayList<>();
			}
			
			num = 0;
			time = 0;
			
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			for(int i=0;i<D;i++) {
				input = br.readLine().split(" ");
				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]);
				int s = Integer.parseInt(input[2]);
				
				graph[b].add(new Edge(a,s));
			}
			
			int start = C;
			dist[start] = 0;
			dijkstra();
			for(int i=1;i<=N;i++) {
				if(dist[i]!=Integer.MAX_VALUE) {
					time = Math.max(time, dist[i]);
					num++;
				}
			}
			
			System.out.println(num+ " "+time);
			T--;
		}
	}
	
	public static void dijkstra() {
		for(int node = 0; node<N-1; node++) {
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			
			for(int i=1;i<=N;i++) {
				if(!visit[i] && dist[i]<min) {
					min = dist[i];
					minIndex = i;
				}
			}
			
			if(minIndex == -1) break;
			visit[minIndex] = true;
			for(int i=0;i<graph[minIndex].size();i++) {
				int end = graph[minIndex].get(i).end;
				int weight = graph[minIndex].get(i).weight;
				if(!visit[end]) {
					if((dist[end] == Integer.MAX_VALUE) || dist[end]>min+weight) {
						dist[end] = min+weight;
					}
				}
			}
			
		}
	
	}
}
