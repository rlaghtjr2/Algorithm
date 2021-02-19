package expert;

import java.util.Scanner;

public class Algo4012 {
	static int N,T;
	static int[][] map;
	static boolean[] check,check2;
	static int[] v,v2,food,food2;
	static int s1,s2;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			map = new int[N][N];
			v = new int[N/2];
			v2 = new int[N/2];
			check = new boolean[N];
			check2 = new boolean[2];
			food = new int[2];
			food2 = new int[2];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			comb(0,0);
			System.out.println("#" + tc+" "+min);
		}
	}
	
	public static void comb(int cnt, int num) {
		if(num == N/2) {
			int vnum = 0;
			int v2num = 0;
			for(int i=0;i<N;i++) {
				if(check[i]) {
					v[vnum] = i;
					vnum++;
				}else {
					v2[v2num] = i;
					v2num++;
				}
			}
			s1=0;
			s2=0;
			comb2(0,0);
			min = Math.min(min, Math.abs(s1-s2));
			return;
		}else if(cnt == 0) {
			check[0] = true;
			comb(cnt+1,1);
		}else {
			for(int i=cnt; i<N;i++) {
				check[i] = true;
				comb(i+1,num+1);
				check[i] = false;
			}
		}
	}
	
	public static void comb2(int cnt, int num) {
		if(num==2) {
			s1+=map[food[0]][food[1]];
			s1+=map[food[1]][food[0]];
			s2+=map[food2[0]][food2[1]];
			s2+=map[food2[1]][food2[0]];
			return;
		}
		
		for(int i=cnt;i<N/2;i++) {
			if(!(cnt==0 && i==(N/2)-1)) {
				food[num] = v[i];
				food2[num] = v2[i];
				comb2(i+1,num+1);
			}
		}
		return;
	}
}
