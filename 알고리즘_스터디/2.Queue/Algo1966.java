package acmpic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair{
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int first() {
		return x;
	}
	
	public int second() {
		return y;
	}
}
public class Algo1966 {
	static int M,N;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		M = Integer.parseInt(sc.nextLine());
		
		for(int tc = 0; tc<M; tc++) {
			int ans = 0;
			int doc;
			Queue<Pair> printer = new LinkedList<>();
			int[] isCheck = new int[10];
			boolean isBreak = true;
			N= sc.nextInt();
			doc = sc.nextInt();
			
			for(int i=0;i<N;i++) {
				int docs = sc.nextInt();
				printer.offer(new Pair(i,docs));
				isCheck[docs]++;
			}
			while(isBreak && !printer.isEmpty()) {
				Pair head = printer.poll();
				//중요도가 높은거이면 뒤에꺼 볼 필요없이 바로 뺌.
				if(head.second() == 9) {
					ans++;
					isCheck[head.second()]--;
					if(head.first() == doc) {
						isBreak = false;
					}
					continue;
					
				}
				
				//중요도가 높인게 아니일때 검사함.
				for(int i=head.second()+1;i<10;i++) {
					//검사중 중요도가 높은게 있을경우 뒤로넣고 break;
					if(isCheck[i]>0) {
						printer.offer(head);
						break;
					}
					//검사중 자신보다 중요도가 높은게 없을경우, 답++, check--, while문종료
					if(i==9) {
						ans++;
						isCheck[head.second()]--;
						if(head.first() == doc) {
							isBreak = false;
						}
					}
				}			
			}
			
			System.out.println(ans);
		}
	}

}
