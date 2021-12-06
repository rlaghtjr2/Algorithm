import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo2309 {
	static int[] child;
	static int[] ans;
	static boolean c;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		child = new int[9];
		ans = new int[7];
		for(int i=0;i<9;i++) {
			child[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(child);
		comb(0,0);
	}
	
	private static void comb(int n, int current) {
		if(n==7) {
			int sum = 0;
			for(int i=0;i<7;i++) {
				sum+=ans[i];
			}
			
			if(sum==100) {
				c = true;
				for(int i=0;i<7;i++) {
					System.out.println(ans[i]);
				}
			}
			return;
		}
		
		for(int i=current;i<9;i++) {
			ans[n] = child[i];
			comb(n+1,i+1);
			if(c) return;
		}
	}

}
