package expert;

import java.util.Arrays;
import java.util.Scanner;

class Pair{
	int x;
	int y;
	
	Pair(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class Algo2105 {
	static int T,N;
	static int[][] map;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {-1,1,1,-1};
	static boolean[] check;
	static int max;
	static int fi,fj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N=sc.nextInt();
			max = Integer.MIN_VALUE;
			check = new boolean[101];
			Arrays.fill(check, false);
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					fi = i;
					fj = j;
					desert(0,new Pair(i,j),0);
				}
			}
			if(max == Integer.MIN_VALUE) {
				max = -1;
			}
			System.out.println("#"+tc+" "+max);
		}
	}
	
	public static void desert(int num, Pair p,int sum) {
		int x = p.x;
		int y = p.y;
		sum++;
		check[map[y][x]] = true;
		
		
		if(x+dx[num]>=N || x+dx[num]<0 || y+dy[num] >= N || y+dy[num]<0) {
		}else if(!check[map[y+dy[num]][x+dx[num]]]){
			desert(num,new Pair(y+dy[num],x+dx[num]),sum);
		}else if(y+dy[num] == fi && x+dx[num] == fj) {
			max = Math.max(max, sum);
			check[map[y][x]] = false;
			return;
		}
		
		if(num>2 || x+dx[num+1]>=N || x+dx[num+1]<0 || y+dy[num+1] >= N || y+dy[num+1]<0) {
			
		}else if(!check[map[y+dy[num+1]][x+dx[num+1]]]){
			desert(num+1,new Pair(y+dy[num+1],x+dx[num+1]),sum);
		}else if(y+dy[num+1] == fi && x+dx[num+1] == fj) {
			max = Math.max(max, sum);
			check[map[y][x]] = false;
			return;
		}
		check[map[y][x]] = false;
	}
}
