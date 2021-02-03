package expert;

import java.util.Scanner;

public class Algo2001 {
	static int T,N,M;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc=1;tc<=10;tc++) {
			int max = -1;
			N=sc.nextInt();
			M=sc.nextInt();
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int num = sc.nextInt();
					map[i][j] = num;
				}
			}
			
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					int num = flySum(i,j);
					max = Math.max(max, num);
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}

	public static int flySum(int y, int x) {
		int sum = 0;
		for(int i=y;i<y+M;i++) {
			for(int j=x;j<x+M;j++) {
				sum+=map[i][j];
			}
		}
		return sum;
	}
}
