package jungol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Algo1828 {
	static int N;
	static int[][] temp;
	static int ans = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		temp = new int[N][2];
		for(int i=0;i<N;i++) {
			temp[i][1] = sc.nextInt();
			temp[i][0] = sc.nextInt();
		}
		
		Arrays.sort(temp, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o2[1] - o1[1];
				}else {
					return o1[0] - o2[0];
				}
			}
		});
		
		int max = temp[0][0];
		
		for(int i=0;i<N;i++) {
			if(max<temp[i][1]) {
				max = temp[i][0];
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}

}
