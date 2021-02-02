package expert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Algo1208 {
	static int dump;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			dump = sc.nextInt();
			ArrayList<Integer> boxs = new ArrayList<>();
			
			for(int i=0;i<100;i++) {
				int box = sc.nextInt();
				boxs.add(box);
			}
			
			Collections.sort(boxs);
			while(dump>0) {
				dump--;
				boxs.set(0, boxs.get(0)+1);
				boxs.set(boxs.size()-1, boxs.get(boxs.size()-1)-1);
				
				if(boxs.get(0)>boxs.get(1) || boxs.get(boxs.size()-1)<boxs.get(boxs.size()-2)) {
					Collections.sort(boxs);
				}
			}
			System.out.println("#"+tc+" "+(boxs.get(boxs.size()-1)-boxs.get(0)));
		}
	}

}
