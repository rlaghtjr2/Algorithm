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
public class Algo2146 {
	static int N,islandNum,min;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				if(Integer.parseInt(input[j])==1) map[i][j] = -1;
				else map[i][j] = 0;
			}
		}
		
		islandNum = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==-1) {
					setNumber(islandNum,i,j);
					islandNum++;
				}
			}
		}
		min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0) {
					for(int k=0;k<4;k++) {
						int ny = i+dy[k];
						int nx = j+dx[k];
						if(ny>=N || ny<0 || nx>=N || nx<0) continue;
						if(map[ny][nx]==0) solve(map[i][j],ny,nx);
					}
				}
			}
		}
//		print();
		System.out.println(min);
	}
	
	private static void solve(int num, int y, int x) {
		boolean[][] visit = new boolean[N][N];
		Queue<Pair> que = new LinkedList<>();
		visit[y][x] = true;
		que.add(new Pair(y,x));
		int cnt = 0;
		while(!que.isEmpty()) {
			int queSize = que.size();
			for(int i=0;i<queSize;i++) {
				Pair p = que.poll();
				for(int j=0;j<4;j++) {
					int ny = p.y+dy[j];
					int nx = p.x+dx[j];
					
					if(ny>=N || ny<0 || nx>=N || nx<0) continue;
					if(visit[ny][nx]) continue;
					if(map[ny][nx]==num) continue;
					
					if(map[ny][nx]!=0) {
						min = Math.min(min, cnt+1);
						return;
					}else {
						que.add(new Pair(ny,nx));
						visit[ny][nx] = true;
					}
				}
			}
			cnt++;
		}
	}
	private static void setNumber(int num,int y, int x) {		
		boolean[][] visit = new boolean[N][N];
		Queue<Pair> que = new LinkedList<>();
		visit[y][x] = true;
		que.add(new Pair(y,x));
		map[y][x] = num;
		while(!que.isEmpty()) {
			Pair p = que.poll();
			map[p.y][p.x]= num; 
			for(int i=0;i<4;i++) {
				int ny = p.y+dy[i];
				int nx = p.x+dx[i];
				
				if(ny>=N || ny<0 || nx>=N || nx<0) continue;
				if(visit[ny][nx]) continue;
				if(map[ny][nx]==0) continue;
				
				que.add(new Pair(ny,nx));
				visit[ny][nx] = true;
			}
		}
	}
	
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
