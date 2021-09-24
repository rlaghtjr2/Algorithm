import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2777 {
	static int T,N,ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			if(N==1) {
				System.out.println(1);
				continue;
			}
			while(N>1) {
				boolean isRunning = false;
				for(int i=9;i>=2;i--) {
					if(N%i==0) {
						ans++;
						N=N/i;
						break;
					}
					
					if(i==2) {
						ans = -1;
						isRunning = true;
						break;
					}
				}
				if(isRunning) break;
			}
			System.out.println(ans);
		}
	}

}
