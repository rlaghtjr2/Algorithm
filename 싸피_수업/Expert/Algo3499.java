package expert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo3499 {
	static int T,N;
	static String[] cards;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = Integer.parseInt(sc.nextLine());
		
		for(int tc=1 ; tc<=T; tc++) {
			N = Integer.parseInt(sc.nextLine());
			cards = sc.nextLine().split(" ");
			
			Queue<String> one = new LinkedList<>();
			Queue<String> two = new LinkedList<>();
			for(int i=0;i<(((N-1)/2)+1);i++) {
				one.add(cards[i]);
			}
			for(int i=(((N-1)/2)+1);i<N;i++) {
				two.add(cards[i]);
			}
			for(int i=0;i<N;i++) {
				if(i%2 == 0) {
					cards[i] = one.poll();
				}else {
					cards[i] = two.poll();
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<cards.length;i++) {
				System.out.print(cards[i]+" ");
			}
			System.out.println();
		}
	}

}
