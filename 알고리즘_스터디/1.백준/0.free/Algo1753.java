import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
class Edge implements Comparable<Edge>{
	int end;
	int weight;
	
	Edge(int _end, int _weight){
		end = _end;
		weight = _weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return weight - o.weight;
	}
}
public class Algo1753 {
	static int V,E,start;
	static List<Edge>[] graph;
	static PriorityQueue<Edge> pq;
	static boolean[] visit;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);
		start = Integer.parseInt(br.readLine());
		graph = new ArrayList[V+1];
		visit = new boolean[V+1];
		dist = new int[V+1];
		pq = new PriorityQueue<>();
		
		for(int i=0;i<dist.length;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<=V;i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for(int i=0;i<E;i++) {
			input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			
			graph[s].add(new Edge(e,w));
		}
		dijkstra();
//		System.out.println(Arrays.toString(dist));
		for(int i=1;i<dist.length;i++) {
			if(dist[i]==Integer.MAX_VALUE) bw.write("INF\n");
			else bw.write(dist[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void dijkstra() {
		pq.add(new Edge(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
//			System.out.println(edge.end+" "+edge.weight);
			if(visit[edge.end]) continue;
			visit[edge.end]= true; 
			for(Edge e : graph[edge.end]) {
//				System.out.println(e.end+ " "+e.weight);
				if(dist[e.end]>e.weight+edge.weight) {
					dist[e.end] = e.weight+edge.weight;
					pq.add(new Edge(e.end,dist[e.end]));
				}
			}
		}
	}
}
