import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2003 {
	static int N,M,start,end,sum,ans;
	static int[] seq;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		seq = new int[N];
		
		input = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			seq[i] = Integer.parseInt(input[i]);
		}
		sum = seq[0];
		while(start!=N && end != N) {
			if(sum>M) {
				sum-=seq[start];
				start++;
			}else if(sum<M) {
				end++;
				if(end!=N) {
					sum+=seq[end];
				}
			}else {
				ans++;
				sum-=seq[start];
				start++;
				end++;
				if(end!=N) {
					sum+=seq[end];
				}
			}
		}
		System.out.println(ans);
	}

}
