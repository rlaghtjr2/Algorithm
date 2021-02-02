package algo;

import java.util.Scanner;

public class Algo4344 {
	
	static int C,N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt();
		
		for(int tc=0;tc<C;tc++) {
			double sum = 0;
			double score = 0;
			int cnt = 0;
			double avg = 0;
		
			N = sc.nextInt();
			double[] scores = new double[N];
			
			for(int i=0;i<N;i++) {
				score = sc.nextInt();
				scores[i] = score;
				sum+=score;
			}
			
			avg = (double)sum/(double)N;
			
			for(int i=0;i<N;i++) {
				if(avg<scores[i]) {
					cnt++;
				}
			}
			
			System.out.printf("%.3f%%\n",(double)cnt*100/N);
			
		}
	}

}
