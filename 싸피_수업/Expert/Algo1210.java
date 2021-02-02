package expert;

import java.util.Arrays;
import java.util.Scanner;
class Pair{
	int x;
	int y;
	
	public Pair() {
	}
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int first() {
		return x;
	}
	
	public int second() {
		return y;
	}
	
	public void setFirst(int a) {
		x = a;
	}
	public void setSecond(int a) {
		y = a;
	}
	
}
public class Algo1210 {
	static int[] dx = {1,-1,0};
	static int[] dy = {0,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10; tc++) {
			int testCase = sc.nextInt();
			int[][] maps = new int[100][100];
			boolean[][] isCheck = new boolean[100][100];
			for(int i=0;i<100;i++) {
				Arrays.fill(isCheck[i], false);
			}
			Pair start = new Pair();
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					int num = sc.nextInt();
					maps[i][j] = num;
					if(num==2) {
						start = new Pair(i,j);
					}
				}
			}
						
			while(start.first()!=0) {
				int first = start.first();
				int second = start.second();
				isCheck[first][second] = true;
				for(int i=0;i<3;i++) {
					if(second+dx[i]<0 || second+dx[i]>=100) {
						continue;
					}else {
						if(maps[first+dy[i]][second+dx[i]] == 1 && !isCheck[first+dy[i]][second+dx[i]]) {
							start.setFirst(first+dy[i]);
							start.setSecond(second+dx[i]);
							break;
						}
					}
					
				}
			}
			System.out.println("#"+tc+" "+start.second());
		}
	}

}
