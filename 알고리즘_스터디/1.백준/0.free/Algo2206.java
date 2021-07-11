import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int y;
	int x;
	int weight;
	
	Node(int _y, int _x, int _weight){
		y = _y;
		x = _x;
		weight = _weight;
	}	
} 
public class Algo2206 {
	static int N,M,answer;
	static int[][] map,dist;
	static int[][] visit;
	static Queue<Node> que;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		visit = new int[N][M];
		dist = new int[N][M];
		
		que = new LinkedList<Node>();
		for(int i=0;i<N;i++) {
			input = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}
		
		bfs();
	}
	private static void bfs() {
		que.add(new Node(0,0,map[0][0]));
		visit[0][0] = 0;
		dist[0][0] = 1;
		while(!que.isEmpty()) {
			int queSize = que.size();
			answer++;
			for(int q = 0; q<queSize; q++) {
				Node node = que.poll();
				if(node.y == N-1 && node.x == M-1) {
					System.out.println(answer);
					return;
				}
				
				for(int i=0;i<4;i++) {
					int ny = node.y+dy[i];
					int nx = node.x+dx[i];
					
					if(ny>=N || ny<0 || nx>=M || nx<0) continue;
					
					if(visit[ny][nx]>node.weight) {
						if(map[ny][nx] == 0) {
							que.add(new Node(ny,nx,node.weight));
							dist[ny][nx] = dist[node.y][node.x]+1;
							visit[ny][nx] = node.weight;
						}else {
							if(node.weight==0) {
								que.add(new Node(ny,nx,node.weight+1));
								dist[ny][nx] = dist[node.y][node.x]+1;
								visit[ny][nx] = node.weight+1;
							}
						}
					}
				}
			}
		}
		System.out.println(-1);
	}

}
