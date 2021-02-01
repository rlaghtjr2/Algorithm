package acmpic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo11866 {
	static int N,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		N = sc.nextInt();
		K = sc.nextInt();
		
		Queue<Integer> circle = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			circle.add(i+1);
		}
		while(!circle.isEmpty()) {
			cnt++;
			if(cnt==K) {
				cnt=0;
				ans.add(circle.poll());
			}else {
				circle.add(circle.poll());
			}
		}
		
		System.out.print("<");
		for(int i=0;i<ans.size();i++) {
			if(i!=ans.size()-1)
				System.out.print(ans.get(i)+", ");
			else 
				System.out.print(ans.get(i));
		}
		System.out.print(">");
	}

}
