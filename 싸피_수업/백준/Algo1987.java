package acmicpc;

import java.util.Scanner;
/*
 * 문제
세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.

입력
첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. (1 ≤ R,C ≤ 20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.

출력
첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.
 */
class Pair {
	int x;
	int y;
	public Pair(int y, int x){
		this.x= x;
		this.y = y;
	}
}
public class Algo1987 {
	static int R,C;
	static String[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[] v = new boolean[91];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.nextLine().split(" ");
		R = Integer.parseInt(a[0]);
		C = Integer.parseInt(a[1]);
		map = new String[R][C];
		for(int i=0;i<R;i++) {
			map[i] = sc.nextLine().split("");
		}
		v[(int)map[0][0].charAt(0)] = true;
		
		dfs(1,new Pair(0,0));
		System.out.println(max);
	}

	public static void dfs(int num,Pair p) {
		v[(int)map[p.y][p.x].charAt(0)]= true;
		max = Math.max(max, num);
		for(int i=0;i<4;i++) {
			int y = p.y+dy[i];
			int x = p.x + dx[i];
			
			if(y<0 || y>=R || x<0 || x>=C)continue;
			
			if(!v[(int)map[y][x].charAt(0)])
				dfs(num+1,new Pair(y,x));
				
		}
		v[(int)map[p.y][p.x].charAt(0)]= false; 
	}
}
