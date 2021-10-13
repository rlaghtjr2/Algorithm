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
public class Algo2636 {
	static int N,M,time,cheeseCnt;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
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
		
		while(dfs()) {
//			print();
		}
		System.out.println(time-1);
		System.out.println(cheeseCnt);
	}
	private static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static boolean dfs() {
		time++;
		boolean isRunning = false;
		Queue<Pair> que = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		boolean[][] cheese = new boolean[N][M];
		que.add(new Pair(0,0));
		v[0][0] = true;
		while(!que.isEmpty()) {
			Pair p = que.poll();
			
			int y = p.y;
			int x = p.x;
			
			for(int i=0;i<4;i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny>=N || ny<0 || nx>=M || nx<0) continue;
				if(v[ny][nx]) continue;
				if(map[ny][nx]==1) {
					isRunning = true;
					cheese[ny][nx] = true;
					continue;
				}
				
				que.add(new Pair(ny,nx));
				v[ny][nx] = true;
			}
		}
		int cnt = 0;
		if(isRunning) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(cheese[i][j]) {
						map[i][j] = 0;
						cnt++;
					}
				}
			}
			cheeseCnt = cnt;
			return true;
		}else {
			return false;
		}
	}
}
