package expert;

import java.util.Scanner;

public class Algo5215 {
	
	static int T, N, L;
	static int[] num;
	static int[] cal;
	static int max = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=1; t<=T;t++) {
			max = -1;
			N= sc.nextInt();
			L=sc.nextInt();
			num = new int[N];
			cal = new int[N];
			
			for(int i=0;i<N;i++) {
				num[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			c(0,0,0);
			System.out.println("#"+t+" "+max);
		}
	}
	
	public static void c(int start, int sumScore, int sumCal) {
		max = Math.max(sumScore, max);
		if(start == N) {
			return;
		}
		
		for(int i=start;i<N; i++) {
			if(sumCal + cal[i] <= L) {
				c(i+1,sumScore+num[i],sumCal+cal[i]);
			}
		}
		return;
	}

}
