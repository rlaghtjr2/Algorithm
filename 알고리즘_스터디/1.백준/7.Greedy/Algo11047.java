package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
/*
 * 문제
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)

둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

출력
첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
 */
public class Algo11047 {
	static int N,K,ans;
	static Integer[] money;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		N = Integer.parseInt(a[0]);
		K = Integer.parseInt(a[1]);
		money = new Integer[N];
		for(int i=0;i<N;i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(money,Collections.reverseOrder());
		
		for(int i=0;i<N;i++) {
			if(K/money[i]>0) {
				ans += K/money[i];
				K = K%money[i];
			}
			if(K==0) {
				break;
			}
		}
		System.out.println(ans);
	}

}
