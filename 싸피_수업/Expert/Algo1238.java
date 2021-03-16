import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int L,start,ans;
	static boolean[][] maps;
	static boolean[] v;
	static Queue<Integer> que;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			L = sc.nextInt();
			start = sc.nextInt();
			que = new LinkedList<Integer>();
			maps = new boolean[101][101];
			v = new boolean[101];
			ans = 0;
			for(int i=0;i<L/2;i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				maps[from][to] = true;
			}
			
			que.add(start);
			while(!que.isEmpty()) {
				int queSize = que.size();
				ans = 0;
				for(int i=0;i<queSize;i++) {
					int a = que.poll();
					ans = Math.max(ans, a);
					for(int j=1;j<101;j++) {
						if(maps[a][j] && !v[j]) {
							v[j] = true;
							que.add(j);
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		
		
	}

}