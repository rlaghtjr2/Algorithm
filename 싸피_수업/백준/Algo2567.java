package acmpic;

import java.util.Scanner;

public class Algo2567 {
	static int N;
	public static void main(String[] args) {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int sum = 0;
		
		boolean[][] isCheck = new boolean[100][100];
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j=x;j<x+10;j++) {
				for(int k=y;k<y+10;k++){
					if(!isCheck[j][k]) {
						isCheck[j][k]=true;
					}
				}
			}
		}
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(isCheck[i][j]) {
					for(int k=0;k<4;k++) {
						if(i+dx[k]<0 || i+dx[k]>=100 ||
								j+dy[k]<0 || j+dy[k]>=100||
								(!isCheck[i+dx[k]][j+dy[k]])) {
							sum++;
						}
					}
				}
			}
		}
		
		System.out.println(sum);
	}

}
