package expert;

import java.util.Arrays;
import java.util.Scanner;

public class Algo1289 {
	static int T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = Integer.parseInt(sc.nextLine());
		
		for(int tc = 1; tc<=T;tc++) {
			int cnt = 0;
			String backup = sc.nextLine();
			
			String[] initial = new String[backup.length()];
			
			Arrays.fill(initial, "0");
			for(int i=0;i<initial.length;i++) {
				if(!initial[i].equals(String.valueOf(backup.charAt(i)))) {
					cnt++;
					for(int j=i;j<initial.length;j++) {
						initial[j] = String.valueOf(backup.charAt(i));
					}
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
		}
		
	}

}
