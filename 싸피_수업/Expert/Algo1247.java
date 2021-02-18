package expert;

import java.util.Scanner;
class Pair {
	int x;
	int y;
	public Pair(int x, int y){
		this.x= x;
		this.y = y;
	}
}
public class Algo1247 {
	static int N,T,M,min;
	static Pair comp,home;
	static Pair[] cus;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			comp = new Pair(x,y);
			
			x = sc.nextInt();
			y = sc.nextInt();
			home = new Pair(x,y);
			
			cus = new Pair[N];
			for(int i=0;i<N;i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				cus[i] = new Pair(x,y);
			}
			v = new boolean[N];
			comb(0,0,comp);
			System.out.println("#"+tc+" "+min);
		}
	}
	private static void comb(int cnt, int sum, Pair current) {
		if(cnt == N) {
			int sum2 = sum + Math.abs(current.x - home.x)+ Math.abs(current.y - home.y); 
			min = Math.min(min, sum2);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			v[i] = true;
			int sum2 = sum+Math.abs(current.x - cus[i].x) + Math.abs(current.y - cus[i].y);
			comb(cnt+1,sum2,cus[i]);
			v[i] = false;
		}
	}

}
