package acmicpc;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Algo1715 {
	static int N,ans;
	static int[] cards;
	static PriorityQueue<Integer> que;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		que = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			que.add(num);
		}
		
		while(que.size()!=1) {
			int a = que.poll();
			int b = que.poll();
			
			ans += (a+b);
			
			que.add(a+b);
		}
		
		System.out.println(ans);
	}

}
