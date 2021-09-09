import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2578 {
	static int ans;
	static int[][] array;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		array = new int[5][5];
		v = new boolean[5][5];
		
		for(int i=0;i<5;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<5;j++) {
				array[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for(int t=0;t<5;t++) {
			String[] input = br.readLine().split(" ");
			for(int i=0;i<5;i++) {
				ans++;
				check(Integer.parseInt(input[i]));
				if(bingo()>=3) {
					System.out.println(ans);
					System.exit(0);
				}
				
			}
		}
	}
	
	
	public static void check(int num) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(array[i][j]==num) {
					v[i][j] = true;
					return;
				}
			}
		}
	}
	
	public static int bingo() {
		int num = 0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(!v[i][j]) break;
			
				if(j==4) num++;
			}
		}
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(!v[j][i]) break;
				if(j==4) num++;
			}
		}
		
		for(int i=0;i<5;i++) {
			if(!v[i][i]) break;
			if(i==4) num++;
		}
		
		for(int i=0;i<5;i++) {
			if(!v[4-i][i]) break;
			if(i==4) num++;
		}
		
		return num;
	}
	
	
}
