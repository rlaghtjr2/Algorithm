package expert;

import java.util.Scanner;

public class Algo3234 {
	static int T,N,a;
	static int[] w,w2;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		T = s.nextInt();
		for(int t=1;t<=T;t++) {
			a = 0;
			N= s.nextInt();
			w = new int[N];
			v = new boolean[N];
			w2 = new int[N];
			for(int i=0;i<N;i++) w[i] = s.nextInt();
			c(0);
			System.out.println("#"+t+" "+a);
		}
	}
	static void c(int c) {
		if(c==N) {
			c2(0,0,0);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			v[i] = true;
			w2[c] = w[i];
			c(c+1);
			v[i] = false;
		}
	}
	
	static void c2(int c,int l, int r) {
		if(c==N) {
			a++;
			return;
		}
		c2(c+1,l+w2[c],r);
		if(l>=r+w2[c]) c2(c+1,l,r+w2[c]);
	}
}
