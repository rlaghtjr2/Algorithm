import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo2212 {
	static int N,K,ans;
	static int[] sensor,dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		if(K>=N) {
			System.out.println(0);
			System.exit(0);
		}
		String[] input = br.readLine().split(" ");
		sensor = new int[N];
		dist = new int[N-1];
		for(int i=0;i<N;i++) {
			sensor[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(sensor);
		
		for(int i=0;i<N-1;i++) {
			dist[i] = sensor[i+1] - sensor[i];
		}
		
		Arrays.sort(dist);
		for(int i=N-2;i>(N-2)-(K-1);i--) {
			dist[i] = 0;
		}
		
		for(int i=0;i<N-1;i++) {
			ans += dist[i];
		}
		
		System.out.println(ans);
	}

}
