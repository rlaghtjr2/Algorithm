package acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 문제
상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.

상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다. 이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500)이 주어진다. 둘째 줄에는 리스트의 길이 m (1 ≤ m ≤ 10000)이 주어진다. 다음 줄부터 m개 줄에는 친구 관계 ai bi가 주어진다. (1 ≤ ai < bi ≤ n) ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계이다. 

출력
첫째 줄에 상근이의 결혼식에 초대하는 동기의 수를 출력한다.
 */
public class Algo5567 {
	static int N,M;
	static boolean[][] friends;
	static boolean[] check;
	static Queue<Integer> que;
	static int ans = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		friends = new boolean[N+1][N+1];
		que = new LinkedList<>();
		check = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			friends[a][b] = true;
			friends[b][a] = true;
		}
		
		check[1] = true;
		for(int i=2;i<N+1;i++) {
			if(friends[1][i] == true) {
				que.add(i);
				ans++;
				check[i] = true;
			}
		}
		int queSize = que.size();
		for(int i=0;i<queSize; i++) {
			int start = que.poll();
			for(int j=0;j<N+1;j++) {
				if(friends[start][j] == true && !check[j]) {
					check[j] = true;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	
}
