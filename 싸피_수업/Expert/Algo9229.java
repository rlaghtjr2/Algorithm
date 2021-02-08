package expert;

import java.util.Scanner;

public class Algo9229 {
	static int T,N,M;
	static int[] snack;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		T = sc.nextInt();
		for(int tc = 1 ; tc<=T; tc++) {
			ans = -1;
			N = sc.nextInt();
			M = sc.nextInt();
			snack = new int[N];
			for(int i=0;i<N;i++) snack[i] = sc.nextInt();
			combi(0,0,0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static void combi(int start, int num, int sum) {
		if(num==2) {
			ans = Math.max(ans, sum);
			return;
		}
		for(int i = start; i<N; i++) if(sum + snack[i] <=M) combi(i+1,num+1,sum+snack[i]);
	}
}
