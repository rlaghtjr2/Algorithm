import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Algo1644 {
	static int N,start,end,ans,sum;
	static boolean[] prime;
	static ArrayList<Integer> seq = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		prime = new boolean[N+1];
		
		//false 이면 소수 true이면 소수아님
		for(int i=2;i<=N;i++) {
			if(prime[i]) continue;
			else {
				for(int j=i*2;j<=N;j=j+i) {
					prime[j] = true;
				}
			}
		}
		
		for(int i=2;i<=N;i++) {
			if(!prime[i]) seq.add(i);
		}
		sum = 2;
		while(start!=seq.size() && end!=seq.size()) {
			if(sum==N) {
				ans++;
				sum-=seq.get(start);
				start++;
				end++;
				if(end!=seq.size()) {
					sum+=seq.get(end);
				}
			}else if(sum>N) {
				sum-=seq.get(start);
				start++;
			}else {
				end++;
				if(end!=seq.size()) {
					sum+=seq.get(end);
				}
			}
		}
		
		System.out.println(ans);
	}

}
