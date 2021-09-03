import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Algo2776 {
	static int T,N,M;
	static HashSet<Integer> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			N = Integer.parseInt(br.readLine());
			set = new HashSet<>();
			String[] input = br.readLine().split(" ");
			for(int i=0;i<input.length;i++) {
				set.add(Integer.parseInt(input[i]));
			}
			
			M = Integer.parseInt(br.readLine());
			input = br.readLine().split(" ");
			for(int i=0;i<input.length;i++) {
				int num = Integer.parseInt(input[i]);
				if(set.contains(num)) bw.write(1+"\n");
				else bw.write(0+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
