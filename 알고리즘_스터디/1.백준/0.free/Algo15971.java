import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
class Node implements Comparable<Node>{
	int room;
	int weight;
	
	Node(int _room, int _weight){
		room = _room;
		weight = _weight;
	}

	@Override
	public int compareTo(Node o) {
		return o.weight-weight;
	}
	
}
public class Algo15971 {
	static int N,startRobot,endRobot;
	static boolean[] visit;
	static int[] dist,max;
	static PriorityQueue<Node> pq;
	static List<Node>[] graph;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N= Integer.parseInt(input[0]);
		startRobot = Integer.parseInt(input[1]);
		endRobot = Integer.parseInt(input[2]);
		graph = new List[N+1];
		dist = new int[N+1];
		max = new int[N+1];
		pq = new PriorityQueue<>();
		visit = new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0;i<N-1;i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			
			graph[start].add(new Node(end,weight));
			graph[end].add(new Node(start,weight));
		}
		dijkstra();
//		System.out.println(dist[endRobot]);
//		System.out.println(Arrays.toString(dist));
//		System.out.println(Arrays.toString(max));
		System.out.println(dist[endRobot]-max[endRobot]);
	}
	
	public static void dijkstra() {
		pq.add(new Node(startRobot,0));
		dist[startRobot] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
//			System.out.println(node.room+" "+node.weight);
			if(visit[node.room]) continue;
			visit[node.room]= true; 
			for(Node n : graph[node.room]) {
				if(dist[n.room]>n.weight+node.weight) {
					dist[n.room] = n.weight+node.weight;
					max[n.room] = Math.max(max[node.room], n.weight); 
					pq.add(new Node(n.room,dist[n.room]));
				}
			}
		}
	}
}
