package expert;

import java.util.Scanner;

public class Algo6808 {
	static int T;
	static int[] guy,in,v;
	static boolean[] check;
	static long ans1,ans2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			ans1 = 0;
			ans2 = 0;
			check = new boolean[19];
			guy = new int[9];
			in = new int[9];
			v = new int[9];
			for(int i=0;i<9;i++) {
				guy[i] = sc.nextInt();
				check[guy[i]] = true;
			}
			int cnt=0;
			for(int i =1;i<19;i++) {
				if(!check[i]) {
					in[cnt] = i;
					cnt++;
				}else 
					check[i] = false;
			}
			per(0);
			System.out.println("#"+tc+" "+ans1+" "+ans2);
		}
	}
	
	public static void per(int cnt) {
		if(cnt == 9) {
			int one = 0;
			int two = 0;
			for(int i=0;i<9;i++) {
				if(guy[i]>v[i]) 
					one += guy[i]+v[i];
				else 
					two += guy[i]+v[i];
			}
			if(one>two) 
				ans1++;
			else if(two>one) 
				ans2++;
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(check[in[i]]) continue;
			v[cnt] = in[i];
			check[in[i]] = true;
			per(cnt+1);
			check[in[i]] = false;
		}
	}
}
