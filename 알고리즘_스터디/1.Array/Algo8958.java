package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Algo8958 {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		
		for(int tc=0;tc<N;tc++) {
			int sum = 0;
			String anss = sc.nextLine();
			
			String[] ans = anss.split("");
			int[] scores = new int[ans.length];
			Arrays.fill(scores, 0);
			
			if(ans[0].equals("O")) {
				scores[0]++;
				sum++;
			}
			
			for(int i=1;i<ans.length;i++) {
				if(ans[i].equals("O")) {
					scores[i] = scores[i-1]+1;
					sum += scores[i];
				}
			}
			System.out.println(sum);
		}
	}

}
