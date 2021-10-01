import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
	int y;
	int x;
	Pair(int _y, int _x){
		y = _y;
		x = _x;
	}
}
public class Algo2638 {
	static int N,M,ans;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		do {
			ans++;
		}while(bfs());
		
		System.out.println(ans);
	}
	
	private static boolean bfs() {
		boolean r = true;
		int[][] check = new int[N][M];
		boolean[][] v = new boolean[N][M];
		Queue<Pair> que = new LinkedList<>();
		que.add(new Pair(0,0));
		v[0][0] = true;
		
		while(!que.isEmpty()) {
			Pair p = que.poll();
			
			for(int i=0;i<4;i++) {
				int ny = p.y+dy[i];
				int nx = p.x+dx[i];
				
				if(ny>=N || ny<0 || nx>=M || nx<0) continue;
				check[ny][nx]++;
				if(map[ny][nx]==1) continue;
				if(v[ny][nx]) continue;
				
				que.add(new Pair(ny,nx));
				v[ny][nx] = true;
			}
		}
		setMap(check);
		
		return checkMap();
	}
	
	static void setMap(int[][] check) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(check[i][j]>=2) map[i][j] = 0;
			}
		}
	}
	
	static boolean checkMap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) return true;
			}
		}
		return false;
	}
}
