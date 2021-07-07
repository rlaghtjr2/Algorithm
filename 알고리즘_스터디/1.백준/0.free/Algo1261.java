import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	int x;
	int y;
	int weight;
	
	Node(int _y, int _x, int _weight){
		x = _x;
		y = _y;
		weight = _weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}
public class Algo1261 {
	static int N,M;
	static int[][] map,dist;
	static boolean[][] visit;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		dist = new int[N][M];
		visit = new boolean[N][M];
		pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			input = br.readLine().split("");
			for(int j=0; j<input.length;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
			
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[0][0] = 0;
		visit[0][0] = true;
		pq.add(new Node(0,0,0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for(int i=0;i<4;i++) {
				if(node.y+dy[i]>=N || node.y+dy[i]<0 || node.x+dx[i]>=M || node.x+dx[i]<0) continue;
				
				int y = node.y+dy[i];
				int x= node.x+dx[i];
				
				if(visit[y][x]) continue;
				dist[y][x] = Math.min(dist[y][x], dist[node.y][node.x]+map[y][x]);
				visit[y][x]= true; 
				pq.add(new Node(y,x,dist[y][x]));
			}
		}
		System.out.println(dist[N-1][M-1]);
	}
}
