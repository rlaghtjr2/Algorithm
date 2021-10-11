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
public class Algo14502 {
	static int N,M,ans;
	static int[][] map;
	static Queue<Pair> que;
	static List<Pair> list;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j]==2) list.add(new Pair(i,j));
			}
		}
		
		setWall(0,0,0);
		System.out.println(ans);
	}
	
	private static void setWall(int y, int x,int cnt) {
		if(cnt==3) {
			dfs();
			return;
		}
		for(int i=y;i<N;i++) {
			for(int j=x;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					setWall(y,x,cnt+1);
					map[i][j]=0;
				}
			}
		}
	}
	
	private static void dfs() {
		que = new LinkedList<>();
		for(int i=0;i<list.size();i++) {
			que.add(list.get(i));
		}
		
		
		boolean[][] check = new boolean[N][M];
		
		while(!que.isEmpty()) {
			Pair p = que.poll();
			
			int y = p.y;
			int x = p.x;
			check[y][x] = true;
			for(int i=0;i<4;i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny>=N|| ny<0 || nx>=M || nx<0) continue;
				if(check[ny][nx]) continue;
				if(map[ny][nx]==1 || map[ny][nx]==2) continue;
				
				que.add(new Pair(ny,nx));
				
			}
		}
		
		setAns(check);
	}
	
	private static void setAns(boolean[][] check) {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
//				System.out.print(map[i][j]+" ");
				if(check[i][j]) continue;
				if(map[i][j]==1) continue;
				
				cnt++;
			}
//			System.out.println();
		}
//		System.out.println("-----------------");
		ans = Math.max(ans, cnt);
	}
}
