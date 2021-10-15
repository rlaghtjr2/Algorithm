import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Pair{
	int y;
	int x;
	
	Pair(int _y, int _x){
		y = _y;
		x = _x;
	}
}
public class Algo17141 {
	static int N,M,ans;
	static int[][] map;
	static List<Pair> list;
	static boolean[] v;
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		list = new ArrayList<>();
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j]==2) {
					list.add(new Pair(i,j));
					map[i][j] = 0;
				}
			}
		}
		
		v = new boolean[list.size()];
		solve(0,0);
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans-1);
	}
	
	private static void solve(int cnt,int num) {
		if(cnt==M) {
			bfs();
			return;
		}
		
		
		for(int i=num;i<list.size();i++) {
			if(v[i]) continue;
			
			v[i] = true;
			map[list.get(i).y][list.get(i).x] = 2;
			solve(cnt+1,i+1);
			v[i] = false;
			map[list.get(i).y][list.get(i).x] = 0;
		}
	}
	
	private static void bfs() {
		int[][] map2 = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map2[i][j] = map[i][j];
			}
		}
		
		boolean[][] check = new boolean[N][N];
		
		Queue<Pair> que = new LinkedList<>();
		for(int i=0;i<v.length;i++) {
			if(v[i]) {
				que.add(new Pair(list.get(i).y,list.get(i).x));
				check[list.get(i).y][list.get(i).x] = true;
			}
		}
		int time = 0;
		while(!que.isEmpty()) {
			int queSize = que.size();
			for(int q = 0; q<queSize;q++) {
				Pair p = que.poll();
				int y = p.y;
				int x = p.x;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=N || ny<0 || nx>=N || nx<0) continue;
					if(check[ny][nx]) continue;
					if(map[ny][nx]==1) continue;
					que.add(new Pair(ny,nx));
					check[ny][nx] = true;
				}
			}
			time++;
		}
		boolean isCheck = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==0 && !check[i][j]) {
					isCheck = false;
					break;
				}
			}
			if(!isCheck) break;
		}
		
		if(isCheck) ans = Math.min(ans, time);
	}
}
