import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1806 {
	static int N,S,start,end,sum,ans;
	static int[] seq;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);
		
		seq = new int[N];
		
		input = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			seq[i] = Integer.parseInt(input[i]);
		}
		
		sum = seq[0];
		ans = Integer.MAX_VALUE;
		while(start!=N && end!=N) {
			if(sum>=S) {
				ans = Math.min(ans, end-start+1);
				sum-=seq[start];
				start++;
			}else {
				end++;
				if(end!=N) {
					sum+=seq[end];
				}
			}
			
		}
		
		if(ans == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(ans);
	}

}
