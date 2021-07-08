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
public class Algo4485 {
	static int N=-1;
	static int cnt = 1;
	static int[][] map,dist;
	static boolean[][] visit;
	static PriorityQueue<Node> pq;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(N!=0) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			if(N==0) break;
			map = new int[N][N];
			dist = new int[N][N];
			visit = new boolean[N][N];
			pq = new PriorityQueue<>();
			
			for(int i=0;i<N;i++) {
				input = br.readLine().split(" ");
				for(int j=0;j<input.length;j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			dij();
			System.out.println("Problem "+cnt+": "+dist[N-1][N-1]);
			cnt++;
			
		}
	}
	
	public static void dij() {
		dist[0][0] = map[0][0];
		visit[0][0] = true;
		pq.add(new Node(0,0,0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			visit[node.y][node.x] = true;
			for(int i=0;i<4;i++) {
				int ny = node.y+dy[i];
				int nx = node.x+dx[i];
				
				
				if(ny>=N || ny<0 || nx>=N || nx<0) continue;
				if(visit[ny][nx]) continue;
				dist[ny][nx] = Math.min(dist[ny][nx], dist[node.y][node.x]+map[ny][nx]);
				pq.add(new Node(ny,nx,dist[ny][nx]));
				
			}
		}
	}
}
