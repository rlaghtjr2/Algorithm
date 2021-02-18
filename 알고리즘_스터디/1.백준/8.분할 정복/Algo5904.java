package acmicpc;

import java.util.Scanner;
/*
 * 문제
Moo는 술자리에서 즐겁게 할 수 있는 게임이다. 이 게임은 Moo수열을 각 사람이 하나씩 순서대로 외치면 되는 게임이다.

Moo 수열은 길이가 무한대이며, 다음과 같이 생겼다. 

m o o m o o o m o o m o o o o m o o m o o o m o o m o o o o o 
Moo 수열은 다음과 같은 방법으로 재귀적으로 만들 수 있다. 먼저, S(0)을 길이가 3인 수열 "m o o"이라고 하자. 1보다 크거나 같은 모든 k에 대해서, S(k)는 S(k-1)과 o가 k+2개인 수열 "m o ... o" 와 S(k-1)을 합쳐서 만들 수 있다.

S(0) = "m o o"
S(1) = "m o o m o o o m o o"
S(2) = "m o o m o o o m o o m o o o o m o o m o o o m o o"
위와 같은 식으로 만들면, 길이가 무한대인 문자열을 만들 수 있으며, 그 수열을 Moo 수열이라고 한다.

N이 주어졌을 때, Moo 수열의 N번째 글자를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N (1 ≤ N ≤ 109)이 주어진다.

출력
N번째 글자를 출력한다.
 */
public class Algo5904 {
	static int N;
	static int o = 2;
	static int m = 1;
	static String ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		setMoo(0);
		System.out.println(ans);
		
	}

	public static void setMoo(int cnt) {
		if(cnt+m == N) {
			ans = "m";
			return;
		}else if((cnt+m+o)>=N) {
			ans = "o";
			return;
		}else if(cnt+m+o+cnt>=N) {
			N -= (cnt+m+o);
			o=2;
			setMoo(0);
			
		}else {
			o++;
			setMoo(cnt+cnt+m+o-1);
		}
	}
}
