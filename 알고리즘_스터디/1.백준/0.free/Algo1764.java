package acmicpc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/*
 문제
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 영어 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

 

듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.

출력
듣보잡의 수와 그 명단을 사전순으로 출력한다.
 */
public class Algo1764 {
	static int N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		String[] num = sc.nextLine().split(" ");
		N=Integer.parseInt(num[0]);
		M=Integer.parseInt(num[1]);
		HashMap<String, Integer> names = new HashMap<>();
		ArrayList<String> ans = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String name = sc.nextLine();
			if(names.get(name)==null) {
				names.put(name, 1);
			}else {
				names.put(name, names.get(name) + 1);
			}
		}
		for(int i=0;i<M;i++) {
			String name = sc.nextLine();
			if(names.get(name)!=null) {
				names.put(name, names.get(name) + 1);
			}
		}
		
		
		for (Map.Entry<String, Integer> elem : names.entrySet()) {
			if(elem.getValue()==2) {
				cnt++;
				ans.add(elem.getKey());
			}
		}
		Collections.sort(ans);
		System.out.println(cnt);
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
	

}
