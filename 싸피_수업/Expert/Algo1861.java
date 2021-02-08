package expert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair{
	int first;
	int second;
	
	Pair(){};
	
	Pair(int first, int second){
		this.first = first;
		this.second = second;
	}
	
	
}
public class Algo1861 {
	static int T,N;
	static int[][] room;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc= 1; tc<=T;tc++) {
			int ans = 0;
			int number = 0;
			N = sc.nextInt();
			room = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					room[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int cnt = dfs(i,j);
					if(cnt>ans) {
						ans = cnt;
						number = room[i][j];
					}else if(cnt==ans && room[i][j]<number) {
						number= room[i][j];
					}
				}
			}
			
			System.out.println("#"+tc+" "+number+" " + ans);
		}
	}
	
	public static int dfs(int y, int x) {
		int ans = 0;
		Queue<Pair> que = new LinkedList<>();
		que.add(new Pair(y,x));
		while(!que.isEmpty()) {
			ans++;
			int size = que.size();
			for(int cnt = 0; cnt<size;cnt++) {
				int first = que.peek().first;
				int second = que.peek().second;
				que.poll();
				for(int i=0;i<4;i++) {
					if(first+dy[i]>=N || first+dy[i]<0 || second+dx[i]>=N || second+dx[i]<0) continue;
					
					if(room[first+dy[i]][second+dx[i]] - room[first][second] == 1) {
						que.add(new Pair(first+dy[i],second+dx[i]));
					}
				}
			}
		}
		return ans;
	}
}
