import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Pair implements Comparable<Pair>{
	int y;
	int x; 
	
	Pair(int _y, int _x){
		y = _y;
		x = _x;
	}

	@Override
	public int compareTo(Pair o) {
		if(y > o.y) return 1;
		else if(y<o.y) return -1;
		else {
			if(x > o.x) return 1;
			else return -1;
		}
	}
}

public class Algo19238 {
	static int N,M,oil,startNumber;
	static int[][] map;
	static Pair taxi;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Pair[] ends;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		oil = Integer.parseInt(input[2]);
		
		map = new int[N][N];
		ends = new Pair[M+3];
		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		input = br.readLine().split(" ");
		taxi = new Pair(Integer.parseInt(input[0])-1,Integer.parseInt(input[1])-1);
		
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			map[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = i+2;
			ends[i+2] = new Pair(Integer.parseInt(input[2]),Integer.parseInt(input[3]));
		}
		
		for(int i=0;i<M;i++) {
			moveCar(0);
			moveCar(1);
		}
		System.out.println(oil);
	}
	
	public static void moveCar(int dir) {
		boolean isRunning = true;
		int useOil = 0;
		Queue<Pair> que = new LinkedList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		que.add(taxi);
		boolean[][] visit = new boolean[N][N];
		visit[taxi.y][taxi.x] = true;
		while(!que.isEmpty() && isRunning) {
			int queSize = que.size();
			for(int q=0; q<queSize;q++) {
				Pair pair = que.poll();
				if(dir == 0 && map[pair.y][pair.x]>1) {
					isRunning = false;
					pq.add(new Pair(pair.y,pair.x));
				}
				
				if(dir ==1 && pair.y == ends[startNumber].y-1 && pair.x == ends[startNumber].x-1) {
					taxi = new Pair(pair.y,pair.x);
					oil += useOil*2;
					return;
				}
				
				for(int i=0;i<4;i++) {
					int ny = pair.y+dy[i];
					int nx = pair.x+dx[i];
					if(ny>=N || ny<0 || nx>=N || nx<0) continue;
					if(visit[ny][nx]) continue;
					if(map[ny][nx] == 1) continue;
					
					que.add(new Pair(ny,nx));
					visit[ny][nx] = true;
				}
			}
			if(!isRunning) continue;
			oil--;
			useOil++;
			if(oil<0) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		if(pq.isEmpty()) {
			System.out.println(-1);
			System.exit(0);
		}
		int y = pq.peek().y;
		int x = pq.peek().x;
		startNumber = map[y][x];
		taxi = new Pair(y,x);
		map[y][x]= -1;
	}
}
