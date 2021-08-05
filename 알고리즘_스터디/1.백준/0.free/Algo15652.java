import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Algo15652 {

	static int N,M;
	static int[] nums,ans;
	static boolean[] v;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		ans = new int[M];
		
		comb(0,0);
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt, int num) throws IOException {
		if(cnt == M) {
			String s="";
			for(int i=0;i<M;i++) {
				s+=(ans[i]+" ");
			}
			bw.write(s+"\n");
			return;
		}
		
		for(int i=num;i<N;i++) {
			ans[cnt] = i+1;
			comb(cnt+1,i);
		}
	}

}
