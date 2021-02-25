package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 문제
월드피자 원주 지점에서 N개의 피자 반죽을 오븐에 넣고 구우려고 한다. 그런데, 월드피자에서 만드는 피자 반죽은 지름이 제각각이다. 그런가하면, 월드피자에서 사용하는 오븐의 모양도 몹시 오묘하다. 이 오븐은 깊은 관처럼 생겼는데, 관의 지름이 깊이에 따라 들쭉날쭉하게 변한다. 아래는 오븐의 단면 예시이다.



피자 반죽은 완성되는 순서대로 오븐에 들어간다. 이렇게 N개의 피자가 오븐에 모두 들어가고 나면, 맨 위의 피자가 얼마나 깊이 들어가 있는지가 궁금하다. 이를 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 오븐의 깊이 D와 피자 반죽의 개수 N이 공백을 사이에 두고 주어진다. (1<=D, N<=300,000) 둘째 줄에는 오븐의 최상단부터 시작하여 깊이에 따른 오븐의 지름이 차례대로 주어진다. 셋째 줄에는 피자 반죽이 완성되는 순서대로, 그 각각의 지름이 주어진다. 오븐의 지름이나 피자 반죽의 지름은 10억 이하의 자연수이다.

출력
첫째 줄에, 마지막 피자 반죽의 위치를 출력한다. 오븐의 최상단이 1이고, 최하단 가장 깊은 곳이 D이 된다. 만약 피자가 모두 오븐에 들어가지 않는다면, 0을 출력한다.
 */
public class Algo1756 {
	static int D,N;
	static int[] oven,pizza;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a = br.readLine().split(" ");
		D = Integer.parseInt(a[0]);
		N = Integer.parseInt(a[1]);
		
		a = br.readLine().split(" ");
		oven = new int[a.length];
		for(int i=0;i<a.length;i++) {
			oven[i] = Integer.parseInt(a[i]);
			if(i>0) {
				oven[i] = Math.min(oven[i-1], oven[i]);
			}
		}
		
		a = br.readLine().split(" ");
		pizza = new int[a.length];
		for(int i=0;i<a.length;i++) {
			pizza[i] = Integer.parseInt(a[i]);
		}
		int num = 0;
		for(int i=oven.length-1;i>=0;i--) {
			if(oven[i]>=pizza[num]) {
				num++;
			}
			if(num==N) {
				System.out.println(i+1);
				System.exit(0);
			}
		}
		
		System.out.println(0);
	}

}
