package acmpic;

import java.util.Scanner;

public class Algo2563 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int sum = 0;
		
		int[][] papers = new int[N][2];
		boolean[][] isCheck = new boolean[100][100];
		for(int i=0;i<N;i++) {
			papers[i][0] = sc.nextInt();
			papers[i][1] = sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=papers[i][1];j<papers[i][1]+10;j++) {
				for(int k=papers[i][0];k<papers[i][0]+10;k++) {
					if(!isCheck[j][k]) {
						sum++;
						isCheck[j][k] = true;
					}
				}
			}
		}
		
		System.out.println(sum);
	}

}
