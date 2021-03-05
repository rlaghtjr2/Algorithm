package acmicpc;

import java.util.PriorityQueue;
import java.util.Scanner;
class Pair implements Comparable<Pair>{
	int y;
	int x;
	
	Pair(int y, int x){
		this.y = y;
		this.x = x;
	}

	@Override
	public int compareTo(Pair o) {
		return o.y - this.y;
	}
	
	
}
public class Algo2933 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int R,C,N;
	static String[][] map;
	static int[] nums;
	static int[] direction;
	static int d = 0;
	static boolean[][] v;
	static PriorityQueue<Pair> que;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		String[] a = sc.nextLine().split(" ");
		R = Integer.parseInt(a[0]);
		C = Integer.parseInt(a[1]);
		
		map = new String[R][C];
		
		for(int i=0;i<R;i++) {
			map[i] = sc.nextLine().split("");
		}
		
		N = Integer.parseInt(sc.nextLine());
		nums = new int[N];
		a = sc.nextLine().split(" ");
		
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(a[i]);
		}
		
		direction = new int[2];
		direction[0] = 0;
		direction[1] = C-1;
		for(int i=0;i<N;i++) {
			que = new PriorityQueue<>();
			v = new boolean[R][C];
			smash(nums[i],i);
		}
		print();
	}
	
	
	public static void smash(int floor,int a) {
		int dir = direction[d];
		d= (d+1)%2;
		
		if(dir==0) {
			for(int i=0;i<C-1;i++) {
				if(map[R-floor][i].equals("x")) {
					map[R-floor][i] = ".";
					v[R-floor][i] = false;
					break;
				}
			}
		}else {
			for(int i=C-1;i>=0;i--) {
				if(map[R-floor][i].equals("x")) {
					map[R-floor][i] = ".";
					v[R-floor][i] = false;
					break;
				}
			}
		}
		cluster(a);
	}
	
	public static void cluster(int a) {
		boolean c = true;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j].equals("x") && !v[i][j]) {
					if(que.size()==0) {
						c = dfs(i,j,que.size());
						if(c) {
							que.clear();
						}
					}else {
						c = dfs(i,j,que.size());
					}
					
				}
			}
		}
		boolean flag = false;
		if(que.size()!=0) {
			while(true) {
				PriorityQueue<Pair> que2 = new PriorityQueue<>();
				while(!que.isEmpty()) {
					Pair p = que.poll();
					v[p.y][p.x] = false;
					que2.add(new Pair((p.y)+1,p.x));
					map[p.y+1][p.x] = "x";
					map[p.y][p.x] = ".";
					
					if(p.y+2>=R || v[p.y+2][p.x]) {
						flag = true;
					}
				}
				que = que2;
				if(flag) {
					break;
				}
			}
		}

	}
	
	public static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean dfs(int first, int second,int num) {
		if(num==0) {
			que.offer(new Pair(first,second));
		}
		boolean c = false;
		v[first][second] = true;
		for(int i=0;i<4;i++) {
			int y = first+dy[i];
			int x = second+dx[i];
			
			if(y>=R || y<0 || x >= C || x<0) continue;
			
			if(map[y][x].equals("x")&&!v[y][x]) {
				c |= dfs(y,x,num);
			}
		}
		if(first==R-1) {
			return true;
		}
		return c;
	} 
	
}
