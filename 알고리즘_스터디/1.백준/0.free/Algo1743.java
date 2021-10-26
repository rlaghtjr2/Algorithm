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
public class Algo1743 {
	static int N,M,K,ans;
	static int[][] map;
	static boolean[][] v;
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		
		v = new boolean[N][M];
		map = new int[N][M];
		for(int i=0;i<K;i++) {
			input = br.readLine().split(" ");
			map[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = 1; 
		}
		
		solve();
		System.out.println(ans);
	}
	
	private static void solve() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!v[i][j] && map[i][j]==1) {
					bfs(i,j);
				}
			}
		}
	}
	
	private static void bfs(int y, int x) {
		int cnt = 0;
		Queue<Pair> que = new LinkedList<>();
		que.add(new Pair(y,x));
		v[y][x] = true;
		while(!que.isEmpty()) {
			int queSize = que.size();
			cnt += queSize;
			for(int q = 0 ; q<queSize;q++) {
				Pair p = que.poll();
				int py = p.y;
				int px = p.x;
				for(int i=0;i<4;i++) {
					int ny = py+dy[i];
					int nx = px+dx[i];
					
					if(ny>=N || ny<0 || nx>=M || nx<0) continue;
					if(v[ny][nx]) continue;
					if(map[ny][nx]==0) continue;
					
					que.add(new Pair(ny,nx));
					v[ny][nx] = true;
				}
			}
		}
		ans = Math.max(ans,cnt);
	}
}
