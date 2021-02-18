package expert;

import java.util.Scanner;

public class Algo1265 {
	static int T,N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			int a = N%M;
			int b = N/M;
			long sum = 1;
			for(int i=0; i<M;i++) {
				if(i<a)
					sum *= (b+1);
				else
					sum *= b;
			}
			
			System.out.println("#"+tc+" "+sum);
		}
		
	}

}
