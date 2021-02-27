package acmicpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
 * 문제
영식이는 다음과 같은 버블 소트 프로그램을 C++로 작성했다.

1
2
3
4
5
6
7
8
9
10
11
12
13
14
bool change = false;
for (int i=1; i<=n+1; i++) {
    change = false;
    for (int j=1; j<=n-i; j++) {
        if (a[j] > a[j+1]) {
            change = true;
            swap(a[j], a[j+1]);
        }
    }
    if (change == false) {
        cout << i << '\n';
        break;
    }
}
위 소스에서 n은 배열의 크기이고, a는 수가 들어있는 배열이다. 수는 배열의 1번방부터 채운다.

위와 같은 소스를 실행시켰을 때, 어떤 값이 출력되는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. N은 500,000보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 A[1]부터 A[N]까지 하나씩 주어진다. A에 들어있는 수는 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
정답을 출력한다.
 */
class Pair{
	int index;
	int num;
	
	Pair(int n, int i){
		index = i;
		num = n;
	}
}
public class Algo1377 {
	static int N,ans;
	static Pair[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		p = new Pair[N];
		
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			p[i] = new Pair(num,i);
		}
		
		Arrays.sort(p,new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.num-o2.num;
			}
		});
		//문제의도 : bublesort에서 몇번 돌려야 소트가 완성되는지 ?
		//전의 index - 현재 index > 0 -> 몇번이동했는지뜸 ->
		//최고로 많이 이동한 index+1이 답임
		for(int i=0;i<N;i++) {
			ans = Math.max(ans, p[i].index-i);
		}
		System.out.println(ans+1);
	}

}
