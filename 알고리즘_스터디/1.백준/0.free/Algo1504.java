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

public class Algo1504 {
	static int N,E,V1,V2;
	static int startToV1,startToV2,v1ToV2,v1ToEnd,v2ToEnd;
	static int[] route;
	static int[] dist;
	static ArrayList<Edge>[] graph;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);
		
		graph = new ArrayList[N+1];
		route = new int[2];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		for(int i=0;i<E;i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			
			graph[a].add(new Edge(b,c));
			graph[b].add(new Edge(a,c));
		}
		input = br.readLine().split(" ");
		V1 = Integer.parseInt(input[0]);
		V2 = Integer.parseInt(input[1]);
		
		
		dist = dijkstra(1);
		startToV1 = dist[V1];
		startToV2 = dist[V2];
		if((startToV1==Integer.MAX_VALUE) && (startToV2==Integer.MAX_VALUE)) {
			System.out.println(-1);
			System.exit(0);
		}
		dist = dijkstra(V1);
		v1ToV2 = dist[V2];
		v1ToEnd = dist[N];
		if(v1ToEnd == Integer.MAX_VALUE) {
			System.out.println(-1);
			System.exit(0);
		}
		dist = dijkstra(V2);
		v2ToEnd = dist[N];
		if((v1ToEnd == Integer.MAX_VALUE) && (v2ToEnd == Integer.MAX_VALUE)) {
			System.out.println(-1);
			System.exit(0);
		}
		route[0] = startToV1+v1ToV2+v2ToEnd;
		route[1] = startToV2+v1ToV2+v1ToEnd;
		//System.out.println(startToV1+ " "+startToV2+ " "+v1ToV2+ " "+v1ToEnd+" "+v2ToEnd);
		//System.out.println(Arrays.toString(route));
		if(Math.min(route[0], route[1]) == 0) {
			System.out.println(-1);
		}else {
			System.out.println(Math.min(route[0], route[1]));
		}
		
	}
	
	public static int[] dijkstra(int start) {
		boolean[] visit = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		for(int node=0;node<N-1;node++) {
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
				int weight =graph[minIndex].get(i).weight;
				
				if(visit[end]) continue;
				
				if(dist[end] == Integer.MAX_VALUE || dist[end]>dist[minIndex]+weight) {
					dist[end] = dist[minIndex]+weight;
				}
			}
		}
		
		dist[start] = 0;
		if(start == 1) {
			startToV1 = dist[V1];
			startToV2 = dist[V2];
		}else if(start == V1) {
			v1ToV2 = dist[V2];
			v1ToEnd = dist[N];
		}else if(start == V2) {
			v2ToEnd = dist[N];
		}
		
		return dist;
	}
}
