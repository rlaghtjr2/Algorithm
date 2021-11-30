import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
class Node implements Comparable<Node>{
	int end;
	int weight;
	
	Node(int _end, int _weight){
		end = _end;
		weight = _weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}
public class Algo1916 {
	static int N,M,A,B;
	static List<Node>[] list;
	static int[] dist;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(dist, 1000000000);
		for(int i=0;i<M;i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			
			list[start].add(new Node(end,weight));
		}
		
		String[] input = br.readLine().split(" ");
		A = Integer.parseInt(input[0]);
		B = Integer.parseInt(input[1]);
		
		dijkstra();
		System.out.println(dist[B]);
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		boolean[] c = new boolean[N+1];
		
		pq.offer(new Node(A,0));
		dist[A] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int current = node.end;
			
			if(!c[current]) {
				c[current] = true;
				
				for(Node n : list[current]) {
					if(!c[n.end] && dist[n.end]>dist[current]+n.weight) {
						dist[n.end]= dist[current]+n.weight;
						pq.add(new Node(n.end,dist[n.end]));
					}
				}
			}
		}
	}

}
