package acmicpc;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 문제
N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다. 각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다. 인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.

오늘부터 인구 이동이 시작되는 날이다.

인구 이동은 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.

국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루동안 연다.
위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
연합을 해체하고, 모든 국경선을 닫는다.
각 나라의 인구수가 주어졌을 때, 인구 이동이 몇 번 발생하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)

둘째 줄부터 N개의 줄에 각 나라의 인구수가 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다. (0 ≤ A[r][c] ≤ 100)

인구 이동이 발생하는 횟수가 2,000번 보다 작거나 같은 입력만 주어진다.

출력
인구 이동이 몇 번 발생하는지 첫째 줄에 출력한다.
 */
class Pair{
	int y;
	int x;
	
	Pair(int y, int x){
		this.y = y;
		this.x = x;
	}
}

public class Algo16234 {
	static int N,L,R,ans,sum;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] v;
	static ArrayList<Pair> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			ans++;
			v = new boolean[N][N];
			boolean check = false;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!v[i][j]) {
						list.clear();
						sum = 0;
						dfs(new Pair(i,j),0,0);
						if(list.size()!=1) {
							check = true;
							sum = sum/list.size();
							for(int k=0;k<list.size();k++) {
								map[list.get(k).y][list.get(k).x] = sum;
							}
						}
					}
				}
			}
			if(!check) {
				break;
			}
		}
		System.out.println(ans-1);
	}
	
	
	public static void dfs(Pair p,int sum2, int counting) {
		int y = p.y;
		int x = p.x;
		list.add(new Pair(y,x));
		v[y][x] = true;
		sum+=map[y][x];
		counting++;
		for(int i=0;i<4;i++) {
			int y1 = y+dy[i];
			int x1 = x+dx[i];
			if(y1>=N || y1<0 || x1>=N || x1<0) continue;
			
			if(Math.abs(map[y][x]-map[y1][x1])>=L && Math.abs(map[y][x]-map[y1][x1]) <=R &&
					!v[y1][x1]) {
				dfs(new Pair(y1,x1),sum,counting);
			}
		}
		
	}
}
