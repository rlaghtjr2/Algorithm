package expert;

import java.util.Scanner;

public class Algo1233 {
	static int N;
	static String commands = "*+-/";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int ans = 1;
			N = Integer.parseInt(sc.nextLine());
			String[][] nodes = new String[N][4];
			for(int i=0;i<N;i++) {
				nodes[i] = sc.nextLine().split(" ");
				
				if(i>N/2) {
					if((int)nodes[i][1].charAt(0)<48 || (int)nodes[i][1].charAt(0)>57) {
						ans = 0;
						break;
					}
				}
			}
			
		
			for(int i=N-1;i>=0;i--) {
				if(commands.indexOf(nodes[i][1])!=-1) {
					if(commands.indexOf(nodes[i][2])==-1 &&
							commands.indexOf(nodes[i][3])==-1) {
						nodes[i][1] = "1";
					}else {
						ans = 0;
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+ ans);
		}
	}

}
