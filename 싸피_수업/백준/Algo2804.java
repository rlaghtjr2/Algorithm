package acmicpc;

import java.util.Scanner;
/*
 * 문제
창영이는 크로스워드 퍼즐을 만들려고 한다.

두 단어 A와 B가 주어진다. A는 가로로 놓여야 하고, B는 세로로 놓여야 한다. 또, 두 단어는 서로 교차해야 한다. (정확히 한 글자를 공유해야 한다) 공유하는 글자는 A와 B에 동시에 포함되어 있는 글자여야 하고, 그런 글자가 여럿인 경우 A에서 제일 먼저 등장하는 글자를 선택한다. 마찬가지로 이 글자가 B에서도 여러 번 등장하면 B에서 제일 처음 나오는 것을 선택한다. 예를 들어, A = "ABBA"이고, B = "CCBB"라면, 아래와 같이 만들 수 있다.

.C..
.C..
ABBA
.B..
입력
첫째 줄에 두 단어 A와 B가 주어진다. 두 단어는 30글자 이내이고, 공백으로 구분되어져 있다. 또, 대문자로만 이루어져 있고, 적어도 한 글자는 두 단어에 포함되어 있다.

출력
A의 길이를 N, B의 길이를 M이라고 했을 때, 출력은 총 M줄이고, 각 줄에는 N개 문자가 있어야 한다. 문제 설명에 나온 것 같이 두 단어가 교차된 형태로 출력되어야 한다. 나머지 글자는 '.'로 출력한다.
 */
public class Algo2804 {
	static String[] s;
	static int x,y;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		s = sc.nextLine().split(" ");
		x = -1;
		y = -1;
		for(int i=0;i<s[0].length();i++) {
			for(int j=0;j<s[1].length();j++) {
				if(s[0].charAt(i) == s[1].charAt(j)) {
					y = i;
					x = j;
					break;
				}
			}
			if(x!=-1 && y!=-1) break;
		}
		
		for(int i=0;i<s[1].length();i++) {
			for(int j=0;j<s[0].length();j++) {
				if(i==x) {
					System.out.print(s[0].charAt(j));
				}else if(j==y) {
					System.out.print(s[1].charAt(i));
				}else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

}
