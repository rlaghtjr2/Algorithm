package acmpic;

import java.util.ArrayList;
import java.util.Scanner;

public class Algo1244 {
	static int cnt,gender,stuCnt,num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> switchs = new ArrayList<>(); 
		switchs.add(0);
		
		cnt = sc.nextInt();
		for(int i=0;i<cnt;i++) {
			int state = sc.nextInt();
			switchs.add(state);
		}
	
		stuCnt = sc.nextInt();
		for(int tc = 0;tc<stuCnt;tc++) {
			gender = sc.nextInt();
			num = sc.nextInt();
			
			if(gender==1) {
				for(int i=num;i<=cnt;i=i+num) {
					switchs.set(i, Math.abs(switchs.get(i)-1));
				}
			}else {
				for(int i=0;i<=cnt/2;i++) {
					if(num+i>cnt || num-i<1)
						break;
										
					if(switchs.get(num+i) == switchs.get(num-i)) {
						int changeNum = Math.abs(switchs.get(num+i)-1);
						switchs.set(num+i,changeNum);
						switchs.set(num-i, changeNum);
					}else {
						break;
					}
				}
			}
		}
		
		for(int i=1;i<=cnt;i++) {
			System.out.print(switchs.get(i)+" ");
			if(i%20 == 0) {
				System.out.println();
			}
		}
	}

}
