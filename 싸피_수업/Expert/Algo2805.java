package expert;

import java.util.Scanner;

public class Algo2805 {
	static int T,N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = Integer.parseInt(sc.nextLine());
		
		for(int tc=1;tc<=T;tc++) {
			int sum = 0;
			N=Integer.parseInt(sc.nextLine());
			int[][] map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String[] line = sc.nextLine().split("");
				for(int j=0;j<line.length;j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(j>=Math.abs(N/2-i) && j<N-Math.abs(N/2-i)) {
						sum+=map[i][j];
					}
				}
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}

}
