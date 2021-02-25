package acmicpc;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 문제
민식이는 다음과 같이 두 개의 명령만 지원하는 새로운 텍스트 에디터를 만들었다.

“type c" : 현재 글의 가장 뒤에 문자 c를 추가한다.
“undo t" : 이전 t초동안 수행된 작업을 역순으로 되돌린다.
처음 텍스트 에디터는 비어있다.

예를 들어, 다음과 같은 명령을 진행했다고 하자.

1초 : type a
2초 : type b
3초 : type c
5초 : undo 3
3초가 끝날 때, 텍스트는 "abc"이다. 5초때, 이전 3초동안 한 작업을 역순으로 되돌려야 한다. c는 지워지고, b도 지워질 것이다. 따라서 a만 남는다.

되돌리기가 되돌리기 될 수도 있다.

예를 들어

1초 : type a
2초 : type b
3초 : undo 2
4초 : undo 2
2초일 때, 텍스트는 “ab"이다. 3초때 모든 것이 되돌리기 되므로 텍스트는 빈 텍스트가 되고, 4초때 3초때 되돌리기 한 것이 되돌리기 되고, 2초때 type b한 것이 지워진다. 따라서 텍스트는 ”a"가 된다.

명령과 수행한 시간이 주어질 때, 마지막에 남은 텍스트를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 명령의 개수 N이 주어진다. 둘째 줄부터 N개의 줄에 명령과 수행한 시간이 주어진다. 항상 시간이 오름차순으로 주어지고, type c에서 c는 알파벳 소문자, undo t에서 t는 1보다 크거나 같고 10^9보다 작거나 같은 자연수이다. N은 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 명령을 수행한 후에 남아있는 텍스트를 출력한다.
 */
class Com{
	String s;
	int time;
	
	Com(String s, int t){
		this.s = s;
		this.time = t;
	}
}
public class Algo1360 {
	static int N;
	static String[][] command;
	static ArrayList<Com> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.nextLine());
		
		command = new String[N][3];
		for(int i=0;i<N;i++) {
			String[] a = sc.nextLine().split(" ");
			command[i] = a;
		}
		
		for(int i=0;i<N;i++) {
			if(command[i][0].equals("type")) {
				if(list.size()==0) {
					list.add(new Com(command[i][1],Integer.parseInt(command[i][2])));
				}else {
					list.add(new Com(list.get(list.size()-1).s + command[i][1],
							Integer.parseInt(command[i][2])));
				}
			}else {
				int curT = Integer.parseInt(command[i][2]);
				int returnT = Integer.parseInt(command[i][1]);
				for(int j=list.size()-1;j>=0;j--) {
					int t = list.get(j).time;
					if(curT-t>returnT) {
						list.add(new Com(list.get(j).s,curT));
						break;
					}
					if(j==0) {
						list.add(new Com("",curT));
					}
				}
			}
		}
		if(list.size()!=0) {
			System.out.println(list.get(list.size()-1).s);
		}
	}	

}
