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

public class Algo2665 {
	static int N;
	static int[][] map,dist;
	static boolean[][] visit;
	static PriorityQueue<Node> pq;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		map = new int[N][N];
		dist = new int[N][N];
		visit = new boolean[N][N];
		pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			input = br.readLine().split("");
			for(int j=0; j<input.length;j++) {
				map[i][j] = Math.abs(Integer.parseInt(input[j])-1);
			}
			
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[0][0] = 0;
		visit[0][0] = true;
		pq.add(new Node(0,0,0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for(int i=0;i<4;i++) {
				if(node.y+dy[i]>=N || node.y+dy[i]<0 || node.x+dx[i]>=N || node.x+dx[i]<0) continue;
				
				int y = node.y+dy[i];
				int x= node.x+dx[i];
				
				if(visit[y][x]) continue;
				dist[y][x] = Math.min(dist[y][x], dist[node.y][node.x]+map[y][x]);
				visit[y][x]= true; 
				pq.add(new Node(y,x,dist[y][x]));
			}
		}
		System.out.println(dist[N-1][N-1]);
	}

}
