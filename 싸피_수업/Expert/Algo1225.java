package expert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo1225 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int test_case = sc.nextInt();
			Queue<Integer> password = new LinkedList<>();
			
			for(int i=0;i<8;i++) {
				int num = sc.nextInt();
				password.add(num);
			}
			int cnt=1;
			while(true) {
				int num = password.poll();
				num -= cnt;
				cnt++;
				if(cnt==6) {
					cnt=1;
				}
				if(num<=0) {
					num = 0;
					password.add(num);
					break;
				}else {
					password.add(num);
				}
			}
			
			System.out.print("#"+tc+" ");
			while(!password.isEmpty()) {
				System.out.print(password.poll()+" ");
			}
			System.out.println();
		}
	}

}
