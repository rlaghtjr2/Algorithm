import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Algo15651 {

	static int N,M;
	static int[] nums,ans;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		ans = new int[M];
		
		comb(0);
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt) throws IOException {
		if(cnt == M) {
			String s="";
			for(int i=0;i<M;i++) {
				s+=(ans[i]+" ");
			}
			bw.write(s+"\n");
//			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			ans[cnt] = i+1;
			comb(cnt+1);
		}
	}

}
