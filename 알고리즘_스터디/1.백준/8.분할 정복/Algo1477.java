package acmicpc;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * 문제
다솜이는 유료 고속도로를 가지고 있다. 다솜이는 현재 고속도로에 휴게소를 N개 가지고 있는데, 휴게소의 위치는 고속도로의 시작으로부터 얼만큼 떨어져 있는지로 주어진다. 다솜이는 지금 휴게소를 M개 더 세우려고 한다.

다솜이는 이미 휴게소가 있는 곳에 휴게소를 또 세울 수 없고, 고속도로의 끝에도 휴게소를 세울 수 없다. 휴게소는 정수 위치에만 세울 수 있다.

다솜이는 이 고속도로를 이용할 때, 모든 휴게소를 방문한다. 다솜이는 휴게소를 M개 더 지어서 휴게소가 없는 구간의 길이의 최댓값을 최소로 하려고 한다. (반드시 M개를 모두 지어야 한다.)

예를 들어, 고속도로의 길이가 1000이고, 현재 휴게소가 {200, 701, 800}에 있고, 휴게소를 1개 더 세우려고 한다고 해보자.

일단, 지금 이 고속도로를 타고 달릴 때, 휴게소가 없는 구간의 최댓값은 200~701구간인 501이다. 하지만, 새로운 휴게소를 451구간에 짓게 되면, 최대가 251이 되어서 최소가 된다.

입력
첫째 줄에 현재 휴게소의 개수 N, 더 지으려고 하는 휴게소의 개수 M, 고속도로의 길이 L이 주어진다. N은 100보다 작거나 같으며, M도 100보다 작거나 같다. L은 100보다 크거나 같고, 1000보다 작거나 같은 정수이다. 모든 휴게소의 위치는 중복되지 않으며, N+M은 L보다 작다. 둘째 줄에, 휴게소의 위치가 공백을 사이에 두고 주어진다.

출력
첫째 줄에 M개의 휴게소를 짓고 난 후에 휴게소가 없는 구간의 최댓값의 최솟값을 출력한다.
 */
class Pair implements Comparable<Pair>{
	double first;
	int second;
	
	Pair(double x, int y){
		first = x;
		second = y;
	}

	@Override
	public int compareTo(Pair o) {
		if((o.first/o.second - this.first/this.second)>0){
			return 1;
		}else if((o.first/o.second - this.first/this.second)<0) {
			return -1;
		}else {
			return 0;
		}
		
	}
}
public class Algo1477 {
	static int N,M,L;
	static int[] rest;
	static PriorityQueue<Pair> que = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		
		rest = new int[N];
		for(int i=0;i<N;i++) {
			rest[i] = sc.nextInt();
		}
		
		Arrays.sort(rest);
		
		for(int i=0;i<N;i++) {
			if(i==0) {
				que.add(new Pair(rest[i],1));
			}else if(i<=N-1) {
				que.add(new Pair(rest[i]-rest[i-1],1));
			}
			if(i==N-1){
				que.add(new Pair(L-rest[i],1));
			}
		}
		while(M!=0) {
			M--;
			Pair a= que.peek();
			que.poll();
			que.add(new Pair(a.first,a.second+1));
		}
		if(que.peek().first%que.peek().second==0.0) {
			System.out.println((int)(que.peek().first/que.peek().second));
		}else {
			System.out.println(((int)(que.peek().first/que.peek().second))+1);
		}
	}

}
