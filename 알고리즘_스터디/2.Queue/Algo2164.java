package acmpic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo2164 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		Queue<Integer> cards = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			cards.add(i+1);
		}
		
		while(cards.size()!=1) {
			cards.poll();
			
			cards.add(cards.poll());
		}
		
		System.out.println(cards.poll());
	}

}
